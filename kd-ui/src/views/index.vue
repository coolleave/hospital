<template>
  <div id="app">
    <!-- 标题 -->
    <div class="header">
      <h1 class="title">重症医疗数据</h1>
      <div class="divider"></div>
    </div>

    <!-- 卡片组 -->
    <div class="card-container">
      <div v-for="(item, index) in items" :key="index" class="card-item">
        <div class="card" :style="{ backgroundColor: item.color }">
          <div class="card-icon">
            <component :is="item.icon" />
          </div>
          <div class="card-content">
            <h2>{{ item.title }}</h2>
            <p>{{ item.value }}</p>
          </div>
        </div>
      </div>
    </div>

    <!-- 主容器 -->
    <div class="main-container">



      <!-- 按键区域 -->
      <div class="button-section">
        <h3 class="section-title">数据采集</h3>
        <div class="button-grid">
          <button
            v-for="btn in buttons"
            :key="btn.id"
            class="grid-btn"
            @click="handleButtonClick(btn)"
            :class="{ active: btn.active }"
          >
            <span class="btn-icon" v-if="btn.active">
              <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <path d="M20 6L9 17l-5-5" />
              </svg>
            </span>
            {{ btn.label }}
          </button>
        </div>
      </div>
      

      <!-- 详细信息 -->
      <div class="details-section">
        <h3 class="section-title">参与机构</h3>
        <div class="hospital-list">
          <div class="hospital-item" v-for="(hospital, index) in hospitals" :key="index">
            <div class="hospital-rank">{{ index + 1 }}</div>
            <div class="hospital-info">
              <div class="hospital-name">{{ hospital.name }}</div>
              <div class="hospital-stats">
                <!-- <span>病例数: {{ hospital.cases }}</span>
                <span>贡献率: {{ hospital.contribution }}%</span> -->
              </div>
            </div>
          </div>
        </div>
        <!-- <div class="data-update">
          数据更新时间: {{ updateTime }}
        </div> -->
      </div>
    </div>

<!-- 放在 </div> 之前 -->
<AddbasesignDialog
  :open.sync="isDialogOpen1"
  :title="dialogTitle1"
  ref="AddbasesignDialog"
/>

<AddrecordDialog
  :open.sync="isDialogOpen2"
  :title="dialogTitle2"
  ref="AddrecordDialog"
/>
 
<AddbiochemistryDialog
  :open.sync="isDialogOpen3"
  :title="dialogTitle3"
  ref="AddbiochemistryDialog"
/>

<AddgasDialog
  :open.sync="isDialogOpen4"
  :title="dialogTitle4"
  ref="AddgasDialog"
/>

<AddhematologyDialog
  :open.sync="isDialogOpen5"
  :title="dialogTitle5"
  ref="AddhematologyDialog"
/>

<AddurinalysisDialog
  :open.sync="isDialogOpen6"
  :title="dialogTitle6"
  ref="AddurinalysisDialog"
/>

<AddvitalsignDialog
  :open.sync="isDialogOpen7"
  :title="dialogTitle7"
  ref="AddvitalsignDialog"
/>

<AddecmoDialog
  :open.sync="isDialogOpen8"
  :title="dialogTitle8"
  ref="AddecmoDialog"
/>


<AddpiccoDialog
  :open.sync="isDialogOpen9"
  :title="dialogTitle9"
  ref="AddpiccoDialog"
/>

<AddbalanceDialog
  :open.sync="isDialogOpen10"
  :title="dialogTitle10"
  ref="AddbalanceDialog"
/>


<AddCpotscoreDialog
  :open.sync="isDialogOpen11"
  :title="dialogTitle11"
  ref="AddCpotscoreDialog"
/>

<AddGcsscoreDialog
  :open.sync="isDialogOpen12"
  :title="dialogTitle12"
  ref="AddGcsscoreDialog"
/>

  </div>
</template>

<script>

import { listDept } from "@/api/system/dept";
import { listUser } from "@/api/system/user";
import { listBasesignAll } from "@/api/system/basesign";


//导入外部组件
// import AddbasesignDialog from "@/components/New_Add/AddbasesignDialog";
export default {
  // components: {
  //   AddbasesignDialog
  // },
  data() {
    return {
      updateTime: new Date().toLocaleString(),
      items: [
        { title: '参与机构', value: '5', color: '#4E7AF5', icon: 'HospitalIcon' },
        { title: '录入病人', value: '0', color: '#FF7D4D', icon: 'PatientIcon' },
        { title: '用户数量', value: '0', color: '#2ECC71', icon: 'UserIcon' },
        { title: '录入病历', value: '30', color: '#9B59B6', icon: 'DownloadIcon' }
      ],
      hospitals: [
        { name: '唐山*****医院', cases: 1250, contribution: 18.5 },
        { name: '河北*****医院', cases: 1250, contribution: 18.5 },
        { name: '邯郸*****医院', cases: 1250, contribution: 18.5 },
        { name: '衡水*****医院', cases: 1250, contribution: 18.5 },
        { name: '邢台*****医院', cases: 1250, contribution: 18.5 }
        // { name: '河北****医院', cases: 980, contribution: 14.2 },
        // { name: '邯郸****医院', cases: 876, contribution: 12.7 },
 
      ],
      buttons: [
        { id: 1, label: '添加病历', active: false },
        { id: 2, label: '添加行医记录', active: false },
        { id: 3, label: '添加肝功能数据', active: false },
        { id: 4, label: '添加血氧分析数据', active: false },
        { id: 5, label: '添加血液分析数据', active: false },
        { id: 6, label: '添加尿液分析数据', active: false },
        { id: 7, label: '添加生命特征数据 ', active: false },
        { id: 8, label: '添加ecmo数据', active: false },
        { id: 9, label: '添加心输出量数据', active: false },
        { id: 10, label: '添加液体平衡数据', active: false },
        { id: 11, label: '添加重症疼痛观察评分', active: false },
        { id: 12, label: '添加格拉斯哥昏迷评分', active: false }
 
      ],
      isDialogOpen1: false,
      dialogTitle1: '添加病历管理',
      isDialogOpen2: false,
      dialogTitle2: '添加行医记录',
      isDialogOpen3: false,
      dialogTitle3: '添加肝功能数据',
      isDialogOpen4: false,
      dialogTitle4: '添加血氧分析数据',
      isDialogOpen5: false,
      dialogTitle5: '添加血液分析数据',
      isDialogOpen6: false,
      dialogTitle6: '添加尿液分析数据',
      isDialogOpen7: false,
      dialogTitle7: '添加生命特征数据',
      isDialogOpen8: false,
      dialogTitle8: '添加ecmo数据',
      isDialogOpen9: false,
      dialogTitle9: '添加心输出量数据',
      isDialogOpen10: false,
      dialogTitle10: '添加液体平衡数据',
      isDialogOpen11: false,
      dialogTitle11: '添加重症疼痛观察评分',
      isDialogOpen12: false,
      dialogTitle12: '添加格拉斯哥昏迷评分'
    };
  },
  created() {
    this.getDepartmentList();
    this.getUserList(); 
    this.getBasesignList(); 
  },
  methods: {
    getDepartmentList() {
      listDept().then(response => {
        const deptData = response.data;
        // 过滤出parentId为100的部门
        const filteredDepts = deptData.filter(dept => dept.parentId === 100);
        
        // 更新items中的"参与机构"的数量
        this.items[0].value = filteredDepts.length.toString();
        
        // 更新hospitals数组
        this.hospitals = filteredDepts.map(dept => ({
          name: dept.deptName,
          cases: dept.cases || 0, // 假设cases是部门的一个属性，如果不存在则默认为0
          contribution: dept.contribution || 0 // 同上
        }));

        console.log("更新后的hospitals:", this.hospitals);
      }).catch(error => {
        console.error("获取部门数据失败：", error)
      })
    },
    // 🆕 新增方法：仅用于打印用户列表到控制台
    getUserList() {
      listUser().then(response => {
        const users = response.rows || response.data || [];
        console.log("获取到的用户列表：", users);

        // 更新用户数量
        this.updateUserCount(users.length);
      }).catch(error => {
        console.error("获取用户列表失败：", error);
      });
    },

    updateUserCount(count) {
      // 找到用户数量对应的item并更新其value
      for (let i = 0; i < this.items.length; i++) {
        if (this.items[i].title === '用户数量') {
          this.items[i].value = count.toString();
          break;
        }
      }
      console.log("更新成功");
    },
    getBasesignList() {
      listBasesignAll().then(response => {
      const records = response.rows || response.data || [];

      console.log("获取到的病历列表：", records);

      const totalRecords = records.length;
      const uniqueIdcards = new Set(records.map(record => record.idcard));
      const patientCount = uniqueIdcards.size;

      this.updateMedicalRecordCount(totalRecords);
      this.updatePatientCount(patientCount);

    }).catch(error => {
      console.error("获取病历列表失败：", error);
    });
  },

  updateMedicalRecordCount(count) {
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].title === '录入病历') {
        this.items[i].value = count.toString();
        break;
      }
    }
  },

  updatePatientCount(count) {
    for (let i = 0; i < this.items.length; i++) {
      if (this.items[i].title === '录入病人') {
        this.items[i].value = count.toString();
        break;
      }
    }
  },
 
    handleButtonClick(btn) {
      if (btn.id === 1) {
    console.log(this.$refs);
    if (this.$refs.AddbasesignDialog && typeof this.$refs.AddbasesignDialog.handleAdd === 'function') {
      this.$refs.AddbasesignDialog.handleAdd(() => {

      });
    } else {
      console.error('无法找到 AddbasesignDialog 或者 handleAdd 方法');
    }

    console.log("更新开始")
        this.getBasesignList();     // 刷新病历数据
        this.getDepartmentList();   // 刷新参与机构
        this.getUserList();         //
  }

    // if (btn.id === 1) {
    //   console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
    //   if(this.$refs.AddbasesignDialog && typeof this.$refs.AddbasesignDialog.handleAdd === 'function') {
    //     this.$refs.AddbasesignDialog.handleAdd();
    //   } else {
    //     console.error('无法找到 addBasesignDialog 或者 handleAdd 方法');
    //   }
    //  }

     if (btn.id === 2) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddrecordDialog && typeof this.$refs.AddrecordDialog.handleAdd === 'function') {
        this.$refs.AddrecordDialog.handleAdd();
      } else {
        console.error('无法找到 addBasesignDialog 或者 handleAdd 方法');
      }
     }

     if (btn.id === 3) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddbiochemistryDialog && typeof this.$refs.AddbiochemistryDialog.handleAdd === 'function') {
        this.$refs.AddbiochemistryDialog.handleAdd();
      } else {
        console.error('无法找到 addBasesignDialog 或者 handleAdd 方法');
      }
     }
     if (btn.id === 4) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddgasDialog && typeof this.$refs.AddgasDialog.handleAdd === 'function') {
        this.$refs.AddgasDialog.handleAdd();
      } else {
        console.error('无法找到 addBasesignDialog 或者 handleAdd 方法');
      }
     }
     if (btn.id === 5) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddhematologyDialog && typeof this.$refs.AddhematologyDialog.handleAdd === 'function') {
        this.$refs.AddhematologyDialog.handleAdd();
      } else {
        console.error('无法找到 addBasesignDialog 或者 handleAdd 方法');
      }
     }
     if (btn.id === 6) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      console.log("点击6"); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddurinalysisDialog && typeof this.$refs.AddurinalysisDialog.handleAdd === 'function') {
        this.$refs.AddurinalysisDialog.handleAdd();
      } else {
        console.error('无法找到 AddurinalysisDialog 或者 handleAdd 方法');
      }
     }
     if (btn.id === 7) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddvitalsignDialog && typeof this.$refs.AddvitalsignDialog.handleAdd === 'function') {
        this.$refs.AddvitalsignDialog.handleAdd();
      } else {
        console.error('无法找到 addBasesignDialog 或者 handleAdd 方法');
      }
     }
     if (btn.id === 8) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddecmoDialog && typeof this.$refs.AddecmoDialog.handleAdd === 'function') {
        this.$refs.AddecmoDialog.handleAdd();
      } else {
        console.error('无法找到 AddecmoDialog 或者 handleAdd 方法');
      }
     }

     if (btn.id === 9) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddpiccoDialog && typeof this.$refs.AddpiccoDialog.handleAdd === 'function') {
        this.$refs.AddpiccoDialog.handleAdd();
      } else {
        console.error('无法找到 AddpiccoDialog 或者 handleAdd 方法');
      }
     }

     
     if (btn.id === 10) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      console.log("点击10")
      if(this.$refs.AddbalanceDialog && typeof this.$refs.AddbalanceDialog.handleAdd === 'function') {
        this.$refs.AddbalanceDialog.handleAdd();
      } else {
        console.error('无法找到 AddbalanceDialog 或者 handleAdd 方法');
      }
     }


     if (btn.id === 11) {
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddCpotscoreDialog && typeof this.$refs.AddCpotscoreDialog.handleAdd === 'function') {
        this.$refs.AddCpotscoreDialog.handleAdd();
      } else {
        console.error('无法找到 AddCpotscoreDialog 或者 handleAdd 方法');
      }
     }


     if (btn.id === 12) {
      console.log("12"); // 检查 $refs 对象中是否存在 addBasesignDialog
      console.log(this.$refs); // 检查 $refs 对象中是否存在 addBasesignDialog
      if(this.$refs.AddGcsscoreDialog && typeof this.$refs.AddGcsscoreDialog.handleAdd === 'function') {
        this.$refs.AddGcsscoreDialog.handleAdd();
      } else {
        console.error('无法找到 AddGcsscoreDialog 或者 handleAdd 方法');
      }
     }

 

  }
  },
  components: {
    HospitalIcon: {
      template: `<svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
        <path d="M3 5h18v18H3zM3 11h18M11 3v18" />
      </svg>`
    },
    PatientIcon: {
      template: `<svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
        <path d="M16 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
        <circle cx="8.5" cy="7" r="4"></circle>
        <line x1="20" y1="8" x2="20" y2="14"></line>
        <line x1="23" y1="11" x2="17" y2="11"></line>
      </svg>`
    },
    UserIcon: {
      template: `<svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
        <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
        <circle cx="9" cy="7" r="4"></circle>
        <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
        <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
      </svg>`
    },
    DownloadIcon: {
      template: `<svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
        <path d="M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4"></path>
        <polyline points="7 10 12 15 17 10"></polyline>
        <line x1="12" y1="15" x2="12" y2="3"></line>
      </svg>`
    }
  }
};
</script>

<style scoped>
/* 基础样式 */
:root {
  --primary-color: #3a5fcd;
  --secondary-color: #e65c2e;
  --success-color: #27ae60;
  --purple-color: #8e44ad;
  --text-color: #333;
  --light-gray: #f5f7fa;
  --medium-gray: #e1e5eb;
  --dark-gray: #6c757d;
  --white: #ffffff;
  --button-bg: #2c3e50;
  --button-active: #1a2530;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

#app {
  font-family: 'Segoe UI', 'PingFang SC', 'Microsoft YaHei', sans-serif;
  color: var(--text-color);
  min-height: 100vh;
  padding: 20px;
  background-color: var(--light-gray);
  display: flex;
  flex-direction: column;
}

/* 标题样式 */
.header {
  margin-bottom: 30px;
  text-align: center;
}

.title {
  font-size: 2.2rem;
  font-weight: 600;
  color: var(--primary-color);
  margin-bottom: 10px;
}

.divider {
  width: 80px;
  height: 4px;
  background: linear-gradient(90deg, var(--primary-color), var(--secondary-color));
  margin: 0 auto;
  border-radius: 2px;
}

/* 卡片组容器 */
.card-container {
  display: flex;
  justify-content: space-between;
  gap: 20px;
  margin-bottom: 40px;
}

/* 单个卡片项 */
.card-item {
  flex: 1;
  min-width: 0;
}

/* 卡片样式 */
.card {
  padding: 25px;
  border-radius: 12px;
  box-shadow: 0 6px 18px rgba(0, 0, 0, 0.08);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  cursor: pointer;
  display: flex;
  align-items: center;
  color: var(--white);
  height: 120px;
}

.card:hover {
  transform: translateY(-5px);
  box-shadow: 0 12px 24px rgba(0, 0, 0, 0.12);
}

.card-icon {
  margin-right: 20px;
  background-color: rgba(255, 255, 255, 0.2);
  border-radius: 50%;
  width: 60px;
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.card-icon svg {
  width: 30px;
  height: 30px;
  stroke-width: 2;
}

.card-content h2 {
  font-size: 1.1rem;
  font-weight: 500;
  margin-bottom: 8px;
}

.card-content p {
  font-size: 1.8rem;
  font-weight: 700;
}

/* 主容器 */
.main-container {
  display: flex;
  flex: 1;
  gap: 30px;
}

/* 按键区域 */
.button-section {
  flex: 3;
  background: var(--white);
  border-radius: 12px;
  padding: 25px 25px 25px 5px; /* 左边距减少为15px */
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}

.section-title {
  font-size: 1.3rem;
  font-weight: 600;
  margin-bottom: 20px;
  color: var(--primary-color);
  display: flex;
  align-items: center;
  padding-left: 10px; /* 标题向左移动 */
}

.section-title::before {
  content: '';
  display: inline-block;
  width: 4px;
  height: 16px;
  background-color: var(--primary-color);
  margin-right: 10px;
  border-radius: 2px;
}

.button-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); /* 按钮宽度增大 */
  gap: 15px;
}

.grid-btn {
  padding: 18px 15px;
  background-color: #07e0e7;
  border: 2px solid #000000;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.3s ease;
  font-size: 1.05rem;
  font-weight: 500;
  height: 200px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #000000;
  position: relative;
  overflow: hidden;
}

.grid-btn:hover,
.grid-btn.active {
  background-color: #e0e0e0;
  border-color: #a08bff;
  color: #2c3e50;
}

.grid-btn.active {
  background-color: var(--button-active); /* 更深的激活状态 */
  color: var(--white);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
}

.btn-icon {
  margin-right: 8px;
  display: flex;
  align-items: center;
}

/* 详细信息区域 */
.details-section {
  flex: 1;
  background: var(--white);
  border-radius: 12px;
  padding: 25px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  display: flex;
  flex-direction: column;
}

.hospital-list {
  flex: 1;
}

.hospital-item {
  display: flex;
  align-items: center;
  padding: 15px 0;
  border-bottom: 1px solid var(--medium-gray);
}

.hospital-item:last-child {
  border-bottom: none;
}

.hospital-rank {
  width: 30px;
  height: 30px;
  background-color: var(--light-gray);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 600;
  margin-right: 15px;
  color: var(--primary-color);
}

.hospital-info {
  flex: 1;
}

.hospital-name {
  font-weight: 600;
  margin-bottom: 5px;
}

.hospital-stats {
  display: flex;
  justify-content: space-between;
  font-size: 0.85rem;
  color: var(--dark-gray);
}

.data-update {
  margin-top: auto;
  font-size: 0.85rem;
  color: var(--dark-gray);
  text-align: right;
  padding-top: 15px;
}

/* 响应式设计 */
@media (max-width: 1200px) {
  .card-container {
    flex-wrap: wrap;
  }
  
  .card-item {
    flex: 0 0 calc(50% - 10px);
    margin-bottom: 20px;
  }
  
  .main-container {
    flex-direction: column;
  }
  
  .button-grid {
    grid-template-columns: repeat(auto-fill, minmax(180px, 1fr));
  }
}

@media (max-width: 768px) {
  .card-item {
    flex: 0 0 100%;
  }
  
  .button-grid {
    grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
  }
  
  .grid-btn {
    height: 70px;
    font-size: 1rem;
  }
}
</style>