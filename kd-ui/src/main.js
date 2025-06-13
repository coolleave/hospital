import Vue from 'vue';
import Cookies from 'js-cookie';
import Element from 'element-ui';
import './assets/styles/element-variables.scss';
import '@/assets/styles/index.scss'; // global css
import '@/assets/styles/ruoyi.scss'; // ruoyi css
import App from './App';
import store from './store';
import router from './router';
import directive from './directive'; // directive
import plugins from './plugins'; // plugins
import { download } from '@/utils/request';
import './assets/icons'; // icon
import './permission'; // permission control
import { getDicts } from "@/api/system/dict/data";
import { getConfigKey } from "@/api/system/config";
import { parseTime, resetForm, addDateRange, selectDictLabel, selectDictLabels, handleTree } from "@/utils/ruoyi";
import Pagination from "@/components/Pagination";
import RightToolbar from "@/components/RightToolbar";
import Editor from "@/components/Editor";
import FileUpload from "@/components/FileUpload";
import ImageUpload from "@/components/ImageUpload";
import ImagePreview from "@/components/ImagePreview";
import DictTag from '@/components/DictTag';
import VueMeta from 'vue-meta';
import DictData from '@/components/DictData';
import AddbasesignDialog from "@/components/New_Add/AddbasesignDialog.vue"; // 引入 AddbasesignDialog 组件
import AddrecordDialog from "@/components/New_Add/AddrecordDialog.vue"; // 引入 AddbasesignDialog 组件
import AddbiochemistryDialog from "@/components/New_Add/AddbiochemistryDialog.vue"; // 引入 AddbasesignDialog 组件
import AddgasDialog from "@/components/New_Add/AddgasDialog.vue"; // 引入 AddbasesignDialog 组件
import AddhematologyDialog from "@/components/New_Add/AddhematologyDialog.vue"; // 引入 AddbasesignDialog 组件
import AddbalanceDialog from "@/components/New_Add/AddbalanceDialog.vue"; // 引入 AddbasesignDialog 组件
import AddvitalsignDialog from "@/components/New_Add/AddvitalsignDialog.vue"; // 引入 AddbasesignDialog 组件
import AddecmoDialog from "@/components/New_Add/AddecmoDialog.vue"; // 引入 AddbasesignDialog 组件
import AddCpotscoreDialog from "@/components/New_Add/AddCpotscoreDialog.vue"; // 引入 AddbasesignDialog 组件
import AddpiccoDialog from "@/components/New_Add/AddpiccoDialog.vue"; // 引入 AddbasesignDialog 组件
import AddGcsscoreDialog from "@/components/New_Add/AddGcsscoreDialog.vue"; // 引入 AddbasesignDialog 组件
import AddurinalysisDialog from "@/components/New_Add/AddurinalysisDialog.vue"; // 引入 AddbasesignDialog 组件
 

 
// 全局方法挂载
Vue.prototype.getDicts = getDicts;
Vue.prototype.getConfigKey = getConfigKey;
Vue.prototype.parseTime = parseTime;
Vue.prototype.resetForm = resetForm;
Vue.prototype.addDateRange = addDateRange;
Vue.prototype.selectDictLabel = selectDictLabel;
Vue.prototype.selectDictLabels = selectDictLabels;
Vue.prototype.download = download;
Vue.prototype.handleTree = handleTree;

// 全局组件挂载
Vue.component('DictTag', DictTag);
Vue.component('Pagination', Pagination);
Vue.component('RightToolbar', RightToolbar);
Vue.component('Editor', Editor);
Vue.component('FileUpload', FileUpload);
Vue.component('ImageUpload', ImageUpload);
Vue.component('ImagePreview', ImagePreview);
Vue.component('AddbasesignDialog', AddbasesignDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddrecordDialog', AddrecordDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddbiochemistryDialog', AddbiochemistryDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddgasDialog', AddgasDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddhematologyDialog', AddhematologyDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddbalanceDialog', AddbalanceDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddvitalsignDialog', AddvitalsignDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddecmoDialog', AddecmoDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddCpotscoreDialog', AddCpotscoreDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddpiccoDialog', AddpiccoDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddGcsscoreDialog', AddGcsscoreDialog); // 全局挂载 AddbasesignDialog 组件
Vue.component('AddurinalysisDialog', AddurinalysisDialog); // 全局挂载 AddbasesignDialog 组件

Vue.use(directive);
Vue.use(plugins);
Vue.use(VueMeta);
DictData.install();

Vue.use(Element, {
  size: Cookies.get('size') || 'medium' // set element-ui default size
});

Vue.config.productionTip = false;

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
});