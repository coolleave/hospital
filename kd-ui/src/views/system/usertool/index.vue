<template>
  <div id="app">
    <!-- 标题 -->
    <h1 style="font-size: 2.5em; margin-bottom: 20px; text-align: center;">医疗数据管理系统用户手册</h1>

    <!-- 导航栏 -->
    <nav class="navbar">
      <ul>
        <li><a href="#introduction">简介</a></li>
        <li><a href="#features">主要功能</a></li>
        <li><a href="#usage">使用指南</a></li>
        <li><a href="#contact">联系我们</a></li>
      </ul>
    </nav>

    <!-- 内容区域 -->
    <section id="content">
      <!-- 简介 -->
      <article id="introduction">
        <h2>简介</h2>
        <p>医疗数据管理系统是一个专门为收录各大医院的数据并提供给广大研究者使用的平台。该系统旨在提高医疗数据的可访问性和利用率，支持医学研究的发展。</p>
      </article>

      <!-- 主要功能 -->
      <article id="features">
        <h2>主要功能</h2>
        <ul>
          <li>数据录入：允许医院工作人员快速录入病人信息。</li>
          <li>数据分析：为研究者提供强大的数据分析工具。</li>
          <li>数据共享：促进不同医疗机构之间的数据共享与合作。</li>
          <li>安全保障：确保所有数据的安全性，保护患者隐私。</li>
        </ul>
      </article>

      <!-- 使用指南 -->
      <article id="usage">
        <h2>使用指南</h2>
        <p>本系统设计了简洁直观的操作流程，帮助用户轻松上手。</p>
        <ol>
          <li>注册账号：通过首页注册新账号或使用已有账号登录。</li>
          <li>浏览数据：在数据面板中查看和搜索所需数据。</li>
          <li>分析数据：利用内置的数据分析工具进行深入研究。</li>
          <li>下载报告：根据需要下载分析结果或生成报告。</li>
        </ol>
      </article>

      <!-- 联系我们 -->
      <article id="contact">
        <h2>联系我们</h2>
        <p>如果您有任何疑问或建议，请随时联系我们。</p>
        <address>
          Email: 750123348@qq.com<br>
          Phone: 16633009823
        </address>
      </article>
    </section>
  </div>
</template>

<script>
export default {
  name: 'UserManual',
};
</script>

<style scoped>
/* 基本样式 */
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: #2c3e50;
  max-width: 1400px; /* 增加最大宽度以适应更宽屏幕 */
  margin: auto;
  padding: 0 20px; /* 增加左右内边距，防止内容贴边 */
}

/* 导航栏样式 */
.navbar ul {
  list-style-type: none;
  padding: 0;
  display: flex;
  justify-content: space-around;
  background-color: #f8f9fa;
  border-bottom: 1px solid #ddd;
}

.navbar ul li {
  padding: 10px;
}

.navbar ul li a {
  text-decoration: none;
  color: #2c3e50;
}

.navbar ul li a:hover {
  text-decoration: underline;
}

/* 内容区域样式 */
#content article {
  margin: 20px 0;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}

#content h2 {
  font-size: 1.8em;
  margin-bottom: 10px;
}

#content p, ol, ul {
  font-size: 1.1em;
  line-height: 1.6;
}
</style>