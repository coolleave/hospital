<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="病历编号" prop="encounterId">
        <el-input
          v-model="queryParams.encounterId"
          placeholder="请输入病历编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="医院ID" prop="hospitalId">
        <el-input
          v-model="queryParams.hospitalId"
          placeholder="请输入医院ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="记录时间">
        <el-date-picker
          v-model="daterangeChartTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <!-- <el-form-item label="尿液pH值" prop="urinePH">
        <el-input
          v-model="queryParams.urinePH"
          placeholder="请输入尿液pH值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="尿红细胞(RBC)，合并 rbc 字段" prop="urineRBC">
        <el-input
          v-model="queryParams.urineRBC"
          placeholder="请输入尿红细胞(RBC)，合并 rbc 字段"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="尿白细胞(WBC)，合并 wbc 字段" prop="urineWBC">
        <el-input
          v-model="queryParams.urineWBC"
          placeholder="请输入尿白细胞(WBC)，合并 wbc 字段"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="尿比重" prop="urineSpecificGravity">
        <el-input
          v-model="queryParams.urineSpecificGravity"
          placeholder="请输入尿比重"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="尿酸盐结晶" prop="urineUrate">
        <el-input
          v-model="queryParams.urineUrate"
          placeholder="请输入尿酸盐结晶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="尿淀粉酶" prop="urineAmylase">
        <el-input
          v-model="queryParams.urineAmylase"
          placeholder="请输入尿淀粉酶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="透明管型" prop="hyalineCasts">
        <el-input
          v-model="queryParams.hyalineCasts"
          placeholder="请输入透明管型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="病理性管型" prop="pathologicalCasts">
        <el-input
          v-model="queryParams.pathologicalCasts"
          placeholder="请输入病理性管型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="尿酸结晶" prop="urateCrystals">
        <el-input
          v-model="queryParams.urateCrystals"
          placeholder="请输入尿酸结晶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="草酸钙结晶" prop="calciumOxalateCrystals">
        <el-input
          v-model="queryParams.calciumOxalateCrystals"
          placeholder="请输入草酸钙结晶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="尿酸结晶" prop="uricAcidCrystals">
        <el-input
          v-model="queryParams.uricAcidCrystals"
          placeholder="请输入尿酸结晶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="鳞状上皮细胞" prop="squamousEpithelialCells">
        <el-input
          v-model="queryParams.squamousEpithelialCells"
          placeholder="请输入鳞状上皮细胞"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="磷酸镁铵结晶" prop="magnesiumAmmoniumPhosphateCrystals">
        <el-input
          v-model="queryParams.magnesiumAmmoniumPhosphateCrystals"
          placeholder="请输入磷酸镁铵结晶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="维生素C" prop="vitaminC">
        <el-input
          v-model="queryParams.vitaminC"
          placeholder="请输入维生素C"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="白细胞簇" prop="leukocyteClusters">
        <el-input
          v-model="queryParams.leukocyteClusters"
          placeholder="请输入白细胞簇"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="黏液丝" prop="mucusThreads">
        <el-input
          v-model="queryParams.mucusThreads"
          placeholder="请输入黏液丝"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="酵母菌" prop="yeast">
        <el-input
          v-model="queryParams.yeast"
          placeholder="请输入酵母菌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="杆菌" prop="bacilli">
        <el-input
          v-model="queryParams.bacilli"
          placeholder="请输入杆菌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="红细胞(RBC)" prop="rbcHPF">
        <el-input
          v-model="queryParams.rbcHPF"
          placeholder="请输入红细胞(RBC)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="非鳞状上皮细胞" prop="nonSquamousEpithelialCells">
        <el-input
          v-model="queryParams.nonSquamousEpithelialCells"
          placeholder="请输入非鳞状上皮细胞"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="精子" prop="spermatozoa">
        <el-input
          v-model="queryParams.spermatozoa"
          placeholder="请输入精子"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="鳞状上皮细胞" prop="squamousEpithelialCellsHPF">
        <el-input
          v-model="queryParams.squamousEpithelialCellsHPF"
          placeholder="请输入鳞状上皮细胞"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="可疑球菌" prop="suspectedCocci">
        <el-input
          v-model="queryParams.suspectedCocci"
          placeholder="请输入可疑球菌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="白细胞(WBC)" prop="wbcHPF">
        <el-input
          v-model="queryParams.wbcHPF"
          placeholder="请输入白细胞(WBC)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="细菌" prop="bacteria">
        <el-input
          v-model="queryParams.bacteria"
          placeholder="请输入细菌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="球菌" prop="cocci">
        <el-input
          v-model="queryParams.cocci"
          placeholder="请输入球菌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="磷酸盐结晶" prop="phosphateCrystals">
        <el-input
          v-model="queryParams.phosphateCrystals"
          placeholder="请输入磷酸盐结晶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="一水草酸钙结晶" prop="monohydrateCalciumOxalateCrystals">
        <el-input
          v-model="queryParams.monohydrateCalciumOxalateCrystals"
          placeholder="请输入一水草酸钙结晶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="二水草酸钙结晶" prop="dihydrateCalciumOxalateCrystals">
        <el-input
          v-model="queryParams.dihydrateCalciumOxalateCrystals"
          placeholder="请输入二水草酸钙结晶"
          clearable
          @keyup.enter.native="handleQuery"
        /> -->
      <!-- </el-form-item> -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:urinalysis:add']"
        >新增</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:urinalysis:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:urinalysis:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['system:basesign:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:urinalysis:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="urinalysisList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="病历编号" align="center" prop="encounterId" />
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="记录时间" align="center" prop="chartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.chartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="尿液pH值" align="center" prop="urinePH" />
      <el-table-column label="尿红细胞(RBC)" align="center" prop="urineRBC" />
      <el-table-column label="尿白细胞(WBC)" align="center" prop="urineWBC" />
      <el-table-column label="尿比重" align="center" prop="urineSpecificGravity" />
      <el-table-column label="尿酸盐结晶" align="center" prop="urineUrate" />
      <el-table-column label="尿淀粉酶" align="center" prop="urineAmylase" />
      <el-table-column label="透明管型" align="center" prop="hyalineCasts" />
      <el-table-column label="病理性管型" align="center" prop="pathologicalCasts" />
      <el-table-column label="尿酸结晶" align="center" prop="urateCrystals" />
      <el-table-column label="草酸钙结晶" align="center" prop="calciumOxalateCrystals" />
      <el-table-column label="尿酸结晶" align="center" prop="uricAcidCrystals" />
      <el-table-column label="鳞状上皮细胞" align="center" prop="squamousEpithelialCells" />
      <el-table-column label="磷酸镁铵结晶" align="center" prop="magnesiumAmmoniumPhosphateCrystals" />
      <el-table-column label="维生素C" align="center" prop="vitaminC" />
      <el-table-column label="白细胞簇" align="center" prop="leukocyteClusters" />
      <el-table-column label="黏液丝" align="center" prop="mucusThreads" />
      <el-table-column label="酵母菌" align="center" prop="yeast" />
      <el-table-column label="杆菌" align="center" prop="bacilli" />
      <el-table-column label="红细胞(RBC)" align="center" prop="rbcHPF" />
      <el-table-column label="非鳞状上皮细胞" align="center" prop="nonSquamousEpithelialCells" />
      <el-table-column label="精子" align="center" prop="spermatozoa" />
      <el-table-column label="鳞状上皮细胞" align="center" prop="squamousEpithelialCellsHPF" />
      <el-table-column label="可疑球菌" align="center" prop="suspectedCocci" />
      <el-table-column label="白细胞(WBC)" align="center" prop="wbcHPF" />
      <el-table-column label="细菌" align="center" prop="bacteria" />
      <el-table-column label="球菌" align="center" prop="cocci" />
      <el-table-column label="磷酸盐结晶" align="center" prop="phosphateCrystals" />
      <el-table-column label="一水草酸钙结晶" align="center" prop="monohydrateCalciumOxalateCrystals" />
      <el-table-column label="二水草酸钙结晶" align="center" prop="dihydrateCalciumOxalateCrystals" />
      <el-table-column label="操作说明" align="center" prop="instructions" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:urinalysis:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:urinalysis:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <div class="el-upload__tip" slot="tip">
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的用户数据
          </div>
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;" @click="importTemplate">下载模板</el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 添加或修改尿液分析数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="病历编号" prop="encounterId">
          <el-input v-model="form.encounterId" placeholder="请输入病历编号" />
        </el-form-item>
        <el-form-item label="医院ID" prop="hospitalId">
          <el-input v-model="form.hospitalId" placeholder="请输入医院ID" />
        </el-form-item>
        <el-form-item label="记录时间" prop="chartTime">
          <el-date-picker clearable
            v-model="form.chartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="尿液pH值" prop="urinePH">
          <el-input v-model="form.urinePH" placeholder="请输入尿液pH值" />
        </el-form-item>
        <el-form-item label="尿红细胞(RBC)，合并 rbc 字段" prop="urineRBC">
          <el-input v-model="form.urineRBC" placeholder="请输入尿红细胞(RBC)，合并 rbc 字段" />
        </el-form-item>
        <el-form-item label="尿白细胞(WBC)，合并 wbc 字段" prop="urineWBC">
          <el-input v-model="form.urineWBC" placeholder="请输入尿白细胞(WBC)，合并 wbc 字段" />
        </el-form-item>
        <el-form-item label="尿比重" prop="urineSpecificGravity">
          <el-input v-model="form.urineSpecificGravity" placeholder="请输入尿比重" />
        </el-form-item>
        <el-form-item label="尿酸盐结晶" prop="urineUrate">
          <el-input v-model="form.urineUrate" placeholder="请输入尿酸盐结晶" />
        </el-form-item>
        <el-form-item label="尿淀粉酶" prop="urineAmylase">
          <el-input v-model="form.urineAmylase" placeholder="请输入尿淀粉酶" />
        </el-form-item>
        <el-form-item label="透明管型" prop="hyalineCasts">
          <el-input v-model="form.hyalineCasts" placeholder="请输入透明管型" />
        </el-form-item>
        <el-form-item label="病理性管型" prop="pathologicalCasts">
          <el-input v-model="form.pathologicalCasts" placeholder="请输入病理性管型" />
        </el-form-item>
        <el-form-item label="尿酸结晶" prop="urateCrystals">
          <el-input v-model="form.urateCrystals" placeholder="请输入尿酸结晶" />
        </el-form-item>
        <el-form-item label="草酸钙结晶" prop="calciumOxalateCrystals">
          <el-input v-model="form.calciumOxalateCrystals" placeholder="请输入草酸钙结晶" />
        </el-form-item>
        <el-form-item label="尿酸结晶" prop="uricAcidCrystals">
          <el-input v-model="form.uricAcidCrystals" placeholder="请输入尿酸结晶" />
        </el-form-item>
        <el-form-item label="鳞状上皮细胞" prop="squamousEpithelialCells">
          <el-input v-model="form.squamousEpithelialCells" placeholder="请输入鳞状上皮细胞" />
        </el-form-item>
        <el-form-item label="磷酸镁铵结晶" prop="magnesiumAmmoniumPhosphateCrystals">
          <el-input v-model="form.magnesiumAmmoniumPhosphateCrystals" placeholder="请输入磷酸镁铵结晶" />
        </el-form-item>
        <el-form-item label="维生素C" prop="vitaminC">
          <el-input v-model="form.vitaminC" placeholder="请输入维生素C" />
        </el-form-item>
        <el-form-item label="白细胞簇" prop="leukocyteClusters">
          <el-input v-model="form.leukocyteClusters" placeholder="请输入白细胞簇" />
        </el-form-item>
        <el-form-item label="黏液丝" prop="mucusThreads">
          <el-input v-model="form.mucusThreads" placeholder="请输入黏液丝" />
        </el-form-item>
        <el-form-item label="酵母菌" prop="yeast">
          <el-input v-model="form.yeast" placeholder="请输入酵母菌" />
        </el-form-item>
        <el-form-item label="杆菌" prop="bacilli">
          <el-input v-model="form.bacilli" placeholder="请输入杆菌" />
        </el-form-item>
        <el-form-item label="红细胞(RBC)" prop="rbcHPF">
          <el-input v-model="form.rbcHPF" placeholder="请输入红细胞(RBC)" />
        </el-form-item>
        <el-form-item label="非鳞状上皮细胞" prop="nonSquamousEpithelialCells">
          <el-input v-model="form.nonSquamousEpithelialCells" placeholder="请输入非鳞状上皮细胞" />
        </el-form-item>
        <el-form-item label="精子" prop="spermatozoa">
          <el-input v-model="form.spermatozoa" placeholder="请输入精子" />
        </el-form-item>
        <el-form-item label="鳞状上皮细胞" prop="squamousEpithelialCellsHPF">
          <el-input v-model="form.squamousEpithelialCellsHPF" placeholder="请输入鳞状上皮细胞" />
        </el-form-item>
        <el-form-item label="可疑球菌" prop="suspectedCocci">
          <el-input v-model="form.suspectedCocci" placeholder="请输入可疑球菌" />
        </el-form-item>
        <el-form-item label="白细胞(WBC)" prop="wbcHPF">
          <el-input v-model="form.wbcHPF" placeholder="请输入白细胞(WBC)" />
        </el-form-item>
        <el-form-item label="细菌" prop="bacteria">
          <el-input v-model="form.bacteria" placeholder="请输入细菌" />
        </el-form-item>
        <el-form-item label="球菌" prop="cocci">
          <el-input v-model="form.cocci" placeholder="请输入球菌" />
        </el-form-item>
        <el-form-item label="磷酸盐结晶" prop="phosphateCrystals">
          <el-input v-model="form.phosphateCrystals" placeholder="请输入磷酸盐结晶" />
        </el-form-item>
        <el-form-item label="一水草酸钙结晶" prop="monohydrateCalciumOxalateCrystals">
          <el-input v-model="form.monohydrateCalciumOxalateCrystals" placeholder="请输入一水草酸钙结晶" />
        </el-form-item>
        <el-form-item label="二水草酸钙结晶" prop="dihydrateCalciumOxalateCrystals">
          <el-input v-model="form.dihydrateCalciumOxalateCrystals" placeholder="请输入二水草酸钙结晶" />
        </el-form-item>
        <el-form-item label="操作说明" prop="instructions">
          <el-input v-model="form.Instructions" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listUrinalysis, getUrinalysis, delUrinalysis, addUrinalysis, updateUrinalysis } from "@/api/system/urinalysis"
import { getToken } from "@/utils/auth";

export default {
  name: "Urinalysis",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 尿液分析数据表格数据
      urinalysisList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 操作说明时间范围
      daterangeChartTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        encounterId: null,
        hospitalId: null,
        chartTime: null,
        urinePH: null,
        urineRBC: null,
        urineWBC: null,
        urineSpecificGravity: null,
        urineUrate: null,
        urineAmylase: null,
        hyalineCasts: null,
        pathologicalCasts: null,
        urateCrystals: null,
        calciumOxalateCrystals: null,
        uricAcidCrystals: null,
        squamousEpithelialCells: null,
        magnesiumAmmoniumPhosphateCrystals: null,
        vitaminC: null,
        leukocyteClusters: null,
        mucusThreads: null,
        yeast: null,
        bacilli: null,
        rbcHPF: null,
        nonSquamousEpithelialCells: null,
        spermatozoa: null,
        squamousEpithelialCellsHPF: null,
        suspectedCocci: null,
        wbcHPF: null,
        bacteria: null,
        cocci: null,
        phosphateCrystals: null,
        monohydrateCalciumOxalateCrystals: null,
        dihydrateCalciumOxalateCrystals: null,
        Instructions: null
      },
      // 表单参数
      form: {},
      upload: {
        // 是否显示弹出层（单词导入）
        open: false,
        // 弹出层标题（单词导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/urinalysis/importData"
      },
      // 表单校验
      rules: {
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询尿液分析数据列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeChartTime && '' != this.daterangeChartTime) {
        this.queryParams.params["beginChartTime"] = this.daterangeChartTime[0]
        this.queryParams.params["endChartTime"] = this.daterangeChartTime[1]
      }
      listUrinalysis(this.queryParams).then(response => {
        this.urinalysisList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        Id: null,
        encounterId: null,
        hospitalId: null,
        chartTime: null,
        urinePH: null,
        urineRBC: null,
        urineWBC: null,
        urineSpecificGravity: null,
        urineUrate: null,
        urineAmylase: null,
        hyalineCasts: null,
        pathologicalCasts: null,
        urateCrystals: null,
        calciumOxalateCrystals: null,
        uricAcidCrystals: null,
        squamousEpithelialCells: null,
        magnesiumAmmoniumPhosphateCrystals: null,
        vitaminC: null,
        leukocyteClusters: null,
        mucusThreads: null,
        yeast: null,
        bacilli: null,
        rbcHPF: null,
        nonSquamousEpithelialCells: null,
        spermatozoa: null,
        squamousEpithelialCellsHPF: null,
        suspectedCocci: null,
        wbcHPF: null,
        bacteria: null,
        cocci: null,
        phosphateCrystals: null,
        monohydrateCalciumOxalateCrystals: null,
        dihydrateCalciumOxalateCrystals: null,
        Instructions: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeChartTime = []
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加尿液分析数据"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const Id = row.id || this.ids
      getUrinalysis(Id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改尿液分析数据"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.Id != null) {
            updateUrinalysis(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addUrinalysis(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const Ids = row.id || this.ids
      this.$modal.confirm('是否确认删除尿液分析数据编号为"' + Ids + '"的数据项？').then(function() {
        return delUrinalysis(Ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },


  
/** 导入按钮操作 */
handleImport() {
  this.upload.title = "用户导入"
  this.upload.open = true
},
/** 下载模板操作 */
importTemplate() {
  this.download('system/urinalysis/importTemplate', {
  }, `user_template_${new Date().getTime()}.xlsx`)
},
// 文件上传中处理
handleFileUploadProgress(event, file, fileList) {
  this.upload.isUploading = true
},
// 文件上传成功处理
handleFileSuccess(response, file, fileList) {
  this.upload.open = false
  this.upload.isUploading = false
  this.$refs.upload.clearFiles()
  this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", { dangerouslyUseHTMLString: true })
  this.getList()
},
// 提交上传文件
submitFileForm() {
  this.$refs.upload.submit()
},


    /** 导出按钮操作 */
    handleExport() {
      this.download('system/urinalysis/export', {
        ...this.queryParams
      }, `urinalysis_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
