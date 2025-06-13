<template>
  <div class="login-container">
    <!-- 首部 -->
    <div class="header-box">
      <div class="el-image head-image">
        <img src="@/assets/logo/logo.png" class="el-image__inner" alt="Logo" />
      </div>
      <h1 class="system-title">{{ title }}</h1>
    </div>

    <!-- 登录表单 -->
    <div class="login-form-container">
      <el-form ref="loginForm" :model="loginForm" :rules="loginRules" label-position="left">
        <h3 class="form-title">登录界面</h3>

        <!-- 用户名 -->
        <el-form-item prop="username">
          <el-input
            v-model="loginForm.username"
            placeholder="账号"
            prefix-icon="user"
          />
        </el-form-item>

        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input
            v-model="loginForm.password"
            type="password"
            placeholder="密码"
            prefix-icon="password"
            @keyup.enter.native="handleLogin"
          />
        </el-form-item>

        <!-- 验证码 -->
        <el-form-item prop="code" v-if="captchaEnabled">
          <el-input
            v-model="loginForm.code"
            placeholder="验证码"
            style="width: 63%"
            @keyup.enter.native="handleLogin"
          >
            <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
          </el-input>
          <div class="login-code">
            <img :src="codeUrl" @click="getCode" class="login-code-img"/>
          </div>
        </el-form-item>

        <!-- 记住密码 -->
        <el-checkbox v-model="loginForm.rememberMe" style="margin: 0 0 25px 0;">记住密码</el-checkbox>

        <!-- 登录按钮 -->
        <el-button
          :loading="loading"
          type="primary"
          style="width:100%;"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>

        <!-- 注册链接 -->
        <div style="float:right;" v-if="register">
          <router-link to="/register" class="link-type">立即注册</router-link>
        </div>
      </el-form>
    </div>

    <!-- 底部版权 -->
    <div class="login-footer">
      © 2025 {{ title }} 版权所有
    </div>
  </div>
</template>


<script>
import { getCodeImg } from "@/api/login"
import Cookies from "js-cookie"
import { encrypt, decrypt } from '@/utils/jsencrypt'

export default {
  name: 'Login',
  data() {
    return {
      title: process.env.VUE_APP_TITLE || '重症医疗数据管理系统',
      codeUrl: '',
      loginForm: {
        username: 'admin',
        password: 'admin123',
        rememberMe: false,
        code: '',
        uuid: ''
      },
      loginRules: {
        username: [{ required: true, message: '请输入账号', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        code: [{ required: true, message: '请输入验证码', trigger: 'change' }]
      },
      loading: false,
      captchaEnabled: true,
      register: false,
      redirect: undefined
    }
  },
  watch: {
    $route: {
      handler(route) {
        this.redirect = route.query?.redirect
      },
      immediate: true
    }
  },
  mounted() {
    document.title = `${this.title} - 登录`
    this.getCode()
    this.getCookie()
  },
  methods: {
    getCode() {
      getCodeImg().then(res => {
        this.captchaEnabled = res.captchaEnabled === undefined ? true : res.captchaEnabled
        if (this.captchaEnabled) {
          this.codeUrl = "data:image/gif;base64," + res.img
          this.loginForm.uuid = res.uuid
        }
      })
    },
    getCookie() {
      const username = Cookies.get("username")
      const password = Cookies.get("password")
      const rememberMe = Cookies.get('rememberMe')
      this.loginForm = {
        username: username ?? this.loginForm.username,
        password: password ? decrypt(password) : this.loginForm.password,
        rememberMe: rememberMe !== undefined ? Boolean(rememberMe) : false
      }
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          if (this.loginForm.rememberMe) {
            Cookies.set("username", this.loginForm.username, { expires: 30 })
            Cookies.set("password", encrypt(this.loginForm.password), { expires: 30 })
            Cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 })
          } else {
            Cookies.remove("username")
            Cookies.remove("password")
            Cookies.remove('rememberMe')
          }
          this.$store.dispatch("Login", this.loginForm)
            .then(() => {
              this.$router.push({ path: this.redirect || '/' }).catch(() => {})
            })
            .catch(() => {
              this.loading = false
              if (this.captchaEnabled) this.getCode()
            })
        }
      })
    }
  }
}
</script>

<style scoped>
.login-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh; /* 使用视口单位使容器占据整个屏幕的高度 */
  background: url("../assets/images/login-background.gif") no-repeat center center fixed;
  background-size: cover;
  font-family: "Microsoft YaHei", sans-serif;
}

.header-box {
  width: 100%;
  padding: 10px 20px;
  box-sizing: border-box;
 
  position: fixed; /* 固定头部位置 */
  top: 0; /* 距离顶部0 */
  z-index: 1000; /* 确保在最上层 */
  display: flex;
  align-items: center;
}

.head-image {
  width: 40px;
  height: 40px;
}

.head-image img {
  width: 100%;
  height: 100%;
  object-fit: contain;
}

.system-title {
  margin-left: 20px;
  font-size: 20px;
  color: #f4f4f7;
  font-weight: bold;
}

.login-form-container {
  width: 100%;
  max-width: 400px;
  background: #fff;
  padding: 30px 25px;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%); /* 居中显示 */
  z-index: 999; /* 在固定头部之下 */
}

.form-title {
  text-align: center;
  margin-bottom: 25px;
  font-size: 22px;
  color: #333;
}

.login-code {
  float: right;
  width: 33%;
  height: 38px;
  margin-top: 5px;
}

.login-code-img {
  height: 100%;
  cursor: pointer;
}

.login-footer {
  position: absolute;
  bottom: 20px;
  width: 100%;
  text-align: center;
  font-size: 13px;
  color: #aaa;
}
</style>