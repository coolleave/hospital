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
      <!-- <el-form-item label="总蛋白" prop="totalProtein">
        <el-input
          v-model="queryParams.totalProtein"
          placeholder="请输入总蛋白"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="白蛋白" prop="albumin">
        <el-input
          v-model="queryParams.albumin"
          placeholder="请输入白蛋白"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="球蛋白" prop="globulin">
        <el-input
          v-model="queryParams.globulin"
          placeholder="请输入球蛋白"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总胆红素" prop="totalBilirubin">
        <el-input
          v-model="queryParams.totalBilirubin"
          placeholder="请输入总胆红素"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="间接胆红素" prop="indirectBilirubin">
        <el-input
          v-model="queryParams.indirectBilirubin"
          placeholder="请输入间接胆红素"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="直接胆红素" prop="directBilirubin">
        <el-input
          v-model="queryParams.directBilirubin"
          placeholder="请输入直接胆红素"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="天冬氨酸氨基转移酶" prop="aspartateAminotransferase">
        <el-input
          v-model="queryParams.aspartateAminotransferase"
          placeholder="请输入天冬氨酸氨基转移酶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="丙氨酸氨基转移酶(SGPT)" prop="alanineAminotransferase">
        <el-input
          v-model="queryParams.alanineAminotransferase"
          placeholder="请输入丙氨酸氨基转移酶(SGPT)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="碱性磷酸酶" prop="alkalinePhosphatase">
        <el-input
          v-model="queryParams.alkalinePhosphatase"
          placeholder="请输入碱性磷酸酶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="同型半胱氨酸" prop="homocysteine">
        <el-input
          v-model="queryParams.homocysteine"
          placeholder="请输入同型半胱氨酸"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总胆汁酸" prop="totalBileAcids">
        <el-input
          v-model="queryParams.totalBileAcids"
          placeholder="请输入总胆汁酸"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="γ谷氨酰转肽酶" prop="gammaGlutamylTransferase">
        <el-input
          v-model="queryParams.gammaGlutamylTransferase"
          placeholder="请输入γ谷氨酰转肽酶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="乳酸脱氢酶" prop="lactateDehydrogenase">
        <el-input
          v-model="queryParams.lactateDehydrogenase"
          placeholder="请输入乳酸脱氢酶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="羟丁酸脱氢酶" prop="hydroxybutyrateDehydrogenase">
        <el-input
          v-model="queryParams.hydroxybutyrateDehydrogenase"
          placeholder="请输入羟丁酸脱氢酶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血清淀粉样蛋白A" prop="serumAmyloidA">
        <el-input
          v-model="queryParams.serumAmyloidA"
          placeholder="请输入血清淀粉样蛋白A"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="谷草比谷丙" prop="astToAltRatio">
        <el-input
          v-model="queryParams.astToAltRatio"
          placeholder="请输入谷草比谷丙"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="前白蛋白" prop="prealbumin">
        <el-input
          v-model="queryParams.prealbumin"
          placeholder="请输入前白蛋白"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="胆碱酯酶" prop="cholinesterase">
        <el-input
          v-model="queryParams.cholinesterase"
          placeholder="请输入胆碱酯酶"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="肌酐" prop="creatinine">
        <el-input
          v-model="queryParams.creatinine"
          placeholder="请输入肌酐"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="尿素氮" prop="ureaNitrogen">
        <el-input
          v-model="queryParams.ureaNitrogen"
          placeholder="请输入尿素氮"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="肾小球滤过率" prop="glomerularFiltrationRate">
        <el-input
          v-model="queryParams.glomerularFiltrationRate"
          placeholder="请输入肾小球滤过率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血清胱抑素C" prop="serumCystatinC">
        <el-input
          v-model="queryParams.serumCystatinC"
          placeholder="请输入血清胱抑素C"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="钾" prop="potassium">
        <el-input
          v-model="queryParams.potassium"
          placeholder="请输入钾"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="钙" prop="calcium">
        <el-input
          v-model="queryParams.calcium"
          placeholder="请输入钙"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="氯" prop="chloride">
        <el-input
          v-model="queryParams.chloride"
          placeholder="请输入氯"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="钠" prop="sodium">
        <el-input
          v-model="queryParams.sodium"
          placeholder="请输入钠"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="二氧化碳总量" prop="totalCarbonDioxide">
        <el-input
          v-model="queryParams.totalCarbonDioxide"
          placeholder="请输入二氧化碳总量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="镁" prop="magnesium">
        <el-input
          v-model="queryParams.magnesium"
          placeholder="请输入镁"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="磷" prop="phosphorus">
        <el-input
          v-model="queryParams.phosphorus"
          placeholder="请输入磷"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="阴离子间隙" prop="anionGap">
        <el-input
          v-model="queryParams.anionGap"
          placeholder="请输入阴离子间隙"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="渗透压" prop="osmolality">
        <el-input
          v-model="queryParams.osmolality"
          placeholder="请输入渗透压"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
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
          v-hasPermi="['system:biochemistry:add']"
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
          v-hasPermi="['system:biochemistry:edit']"
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
          v-hasPermi="['system:biochemistry:remove']"
        >删除</el-button>
      </el-col> -->

      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['system:biochemistry:import']"
        >导入</el-button>
      </el-col>


      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:biochemistry:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="biochemistryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="病历编号" align="center" prop="encounterId" />
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="记录时间" align="center" prop="chartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.chartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="总蛋白" align="center" prop="totalProtein" />
      <el-table-column label="白蛋白" align="center" prop="albumin" />
      <el-table-column label="球蛋白" align="center" prop="globulin" />
      <el-table-column label="总胆红素" align="center" prop="totalBilirubin" />
      <el-table-column label="间接胆红素" align="center" prop="indirectBilirubin" />
      <el-table-column label="直接胆红素" align="center" prop="directBilirubin" />
      <el-table-column label="天冬氨酸氨基转移酶" align="center" prop="aspartateAminotransferase" />
      <el-table-column label="丙氨酸氨基转移酶(SGPT)" align="center" prop="alanineAminotransferase" />
      <el-table-column label="碱性磷酸酶" align="center" prop="alkalinePhosphatase" />
      <el-table-column label="同型半胱氨酸" align="center" prop="homocysteine" />
      <el-table-column label="总胆汁酸" align="center" prop="totalBileAcids" />
      <el-table-column label="γ谷氨酰转肽酶" align="center" prop="gammaGlutamylTransferase" />
      <el-table-column label="乳酸脱氢酶" align="center" prop="lactateDehydrogenase" />
      <el-table-column label="羟丁酸脱氢酶" align="center" prop="hydroxybutyrateDehydrogenase" />
      <el-table-column label="血清淀粉样蛋白A" align="center" prop="serumAmyloidA" />
      <el-table-column label="谷草比谷丙" align="center" prop="astToAltRatio" />
      <el-table-column label="前白蛋白" align="center" prop="prealbumin" />
      <el-table-column label="胆碱酯酶" align="center" prop="cholinesterase" />
      <el-table-column label="肌酐" align="center" prop="creatinine" />
      <el-table-column label="尿素氮" align="center" prop="ureaNitrogen" />
      <el-table-column label="肾小球滤过率" align="center" prop="glomerularFiltrationRate" />
      <el-table-column label="血清胱抑素C" align="center" prop="serumCystatinC" />
      <el-table-column label="钾" align="center" prop="potassium" />
      <el-table-column label="钙" align="center" prop="calcium" />
      <el-table-column label="氯" align="center" prop="chloride" />
      <el-table-column label="钠" align="center" prop="sodium" />
      <el-table-column label="二氧化碳总量" align="center" prop="totalCarbonDioxide" />
      <el-table-column label="镁" align="center" prop="magnesium" />
      <el-table-column label="磷" align="center" prop="phosphorus" />
      <el-table-column label="阴离子间隙" align="center" prop="anionGap" />
      <el-table-column label="渗透压" align="center" prop="osmolality" />
      <el-table-column label="操作说明" align="center" prop="Instructions" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:biochemistry:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:biochemistry:remove']"
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


    <!-- 添加或修改肝功能生化指标对话框 -->
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
        <el-form-item label="总蛋白" prop="totalProtein">
          <el-input v-model="form.totalProtein" placeholder="请输入总蛋白" />
        </el-form-item>
        <el-form-item label="白蛋白" prop="albumin">
          <el-input v-model="form.albumin" placeholder="请输入白蛋白" />
        </el-form-item>
        <el-form-item label="球蛋白" prop="globulin">
          <el-input v-model="form.globulin" placeholder="请输入球蛋白" />
        </el-form-item>
        <el-form-item label="总胆红素" prop="totalBilirubin">
          <el-input v-model="form.totalBilirubin" placeholder="请输入总胆红素" />
        </el-form-item>
        <el-form-item label="间接胆红素" prop="indirectBilirubin">
          <el-input v-model="form.indirectBilirubin" placeholder="请输入间接胆红素" />
        </el-form-item>
        <el-form-item label="直接胆红素" prop="directBilirubin">
          <el-input v-model="form.directBilirubin" placeholder="请输入直接胆红素" />
        </el-form-item>
        <el-form-item label="天冬氨酸氨基转移酶" prop="aspartateAminotransferase">
          <el-input v-model="form.aspartateAminotransferase" placeholder="请输入天冬氨酸氨基转移酶" />
        </el-form-item>
        <el-form-item label="丙氨酸氨基转移酶(SGPT)" prop="alanineAminotransferase">
          <el-input v-model="form.alanineAminotransferase" placeholder="请输入丙氨酸氨基转移酶(SGPT)" />
        </el-form-item>
        <el-form-item label="碱性磷酸酶" prop="alkalinePhosphatase">
          <el-input v-model="form.alkalinePhosphatase" placeholder="请输入碱性磷酸酶" />
        </el-form-item>
        <el-form-item label="同型半胱氨酸" prop="homocysteine">
          <el-input v-model="form.homocysteine" placeholder="请输入同型半胱氨酸" />
        </el-form-item>
        <el-form-item label="总胆汁酸" prop="totalBileAcids">
          <el-input v-model="form.totalBileAcids" placeholder="请输入总胆汁酸" />
        </el-form-item>
        <el-form-item label="γ谷氨酰转肽酶" prop="gammaGlutamylTransferase">
          <el-input v-model="form.gammaGlutamylTransferase" placeholder="请输入γ谷氨酰转肽酶" />
        </el-form-item>
        <el-form-item label="乳酸脱氢酶" prop="lactateDehydrogenase">
          <el-input v-model="form.lactateDehydrogenase" placeholder="请输入乳酸脱氢酶" />
        </el-form-item>
        <el-form-item label="羟丁酸脱氢酶" prop="hydroxybutyrateDehydrogenase">
          <el-input v-model="form.hydroxybutyrateDehydrogenase" placeholder="请输入羟丁酸脱氢酶" />
        </el-form-item>
        <el-form-item label="血清淀粉样蛋白A" prop="serumAmyloidA">
          <el-input v-model="form.serumAmyloidA" placeholder="请输入血清淀粉样蛋白A" />
        </el-form-item>
        <el-form-item label="谷草比谷丙" prop="astToAltRatio">
          <el-input v-model="form.astToAltRatio" placeholder="请输入谷草比谷丙" />
        </el-form-item>
        <el-form-item label="前白蛋白" prop="prealbumin">
          <el-input v-model="form.prealbumin" placeholder="请输入前白蛋白" />
        </el-form-item>
        <el-form-item label="胆碱酯酶" prop="cholinesterase">
          <el-input v-model="form.cholinesterase" placeholder="请输入胆碱酯酶" />
        </el-form-item>
        <el-form-item label="肌酐" prop="creatinine">
          <el-input v-model="form.creatinine" placeholder="请输入肌酐" />
        </el-form-item>
        <el-form-item label="尿素氮" prop="ureaNitrogen">
          <el-input v-model="form.ureaNitrogen" placeholder="请输入尿素氮" />
        </el-form-item>
        <el-form-item label="肾小球滤过率" prop="glomerularFiltrationRate">
          <el-input v-model="form.glomerularFiltrationRate" placeholder="请输入肾小球滤过率" />
        </el-form-item>
        <el-form-item label="血清胱抑素C" prop="serumCystatinC">
          <el-input v-model="form.serumCystatinC" placeholder="请输入血清胱抑素C" />
        </el-form-item>
        <el-form-item label="钾" prop="potassium">
          <el-input v-model="form.potassium" placeholder="请输入钾" />
        </el-form-item>
        <el-form-item label="钙" prop="calcium">
          <el-input v-model="form.calcium" placeholder="请输入钙" />
        </el-form-item>
        <el-form-item label="氯" prop="chloride">
          <el-input v-model="form.chloride" placeholder="请输入氯" />
        </el-form-item>
        <el-form-item label="钠" prop="sodium">
          <el-input v-model="form.sodium" placeholder="请输入钠" />
        </el-form-item>
        <el-form-item label="二氧化碳总量" prop="totalCarbonDioxide">
          <el-input v-model="form.totalCarbonDioxide" placeholder="请输入二氧化碳总量" />
        </el-form-item>
        <el-form-item label="镁" prop="magnesium">
          <el-input v-model="form.magnesium" placeholder="请输入镁" />
        </el-form-item>
        <el-form-item label="磷" prop="phosphorus">
          <el-input v-model="form.phosphorus" placeholder="请输入磷" />
        </el-form-item>
        <el-form-item label="阴离子间隙" prop="anionGap">
          <el-input v-model="form.anionGap" placeholder="请输入阴离子间隙" />
        </el-form-item>
        <el-form-item label="渗透压" prop="osmolality">
          <el-input v-model="form.osmolality" placeholder="请输入渗透压" />
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
import { listBiochemistry, getBiochemistry, delBiochemistry, addBiochemistry, updateBiochemistry } from "@/api/system/biochemistry"
import { getToken } from "@/utils/auth";
export default {
  name: "Biochemistry",
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
      // 肝功能生化指标表格数据
      biochemistryList: [],
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
        totalProtein: null,
        albumin: null,
        globulin: null,
        totalBilirubin: null,
        indirectBilirubin: null,
        directBilirubin: null,
        aspartateAminotransferase: null,
        alanineAminotransferase: null,
        alkalinePhosphatase: null,
        homocysteine: null,
        totalBileAcids: null,
        gammaGlutamylTransferase: null,
        lactateDehydrogenase: null,
        hydroxybutyrateDehydrogenase: null,
        serumAmyloidA: null,
        astToAltRatio: null,
        prealbumin: null,
        cholinesterase: null,
        creatinine: null,
        ureaNitrogen: null,
        glomerularFiltrationRate: null,
        serumCystatinC: null,
        potassium: null,
        calcium: null,
        chloride: null,
        sodium: null,
        totalCarbonDioxide: null,
        magnesium: null,
        phosphorus: null,
        anionGap: null,
        osmolality: null,
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
        url: process.env.VUE_APP_BASE_API + "/system/biochemistry/importData"
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
    /** 查询肝功能生化指标列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeChartTime && '' != this.daterangeChartTime) {
        this.queryParams.params["beginChartTime"] = this.daterangeChartTime[0]
        this.queryParams.params["endChartTime"] = this.daterangeChartTime[1]
      }
      listBiochemistry(this.queryParams).then(response => {
        this.biochemistryList = response.rows
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
        totalProtein: null,
        albumin: null,
        globulin: null,
        totalBilirubin: null,
        indirectBilirubin: null,
        directBilirubin: null,
        aspartateAminotransferase: null,
        alanineAminotransferase: null,
        alkalinePhosphatase: null,
        homocysteine: null,
        totalBileAcids: null,
        gammaGlutamylTransferase: null,
        lactateDehydrogenase: null,
        hydroxybutyrateDehydrogenase: null,
        serumAmyloidA: null,
        astToAltRatio: null,
        prealbumin: null,
        cholinesterase: null,
        creatinine: null,
        ureaNitrogen: null,
        glomerularFiltrationRate: null,
        serumCystatinC: null,
        potassium: null,
        calcium: null,
        chloride: null,
        sodium: null,
        totalCarbonDioxide: null,
        magnesium: null,
        phosphorus: null,
        anionGap: null,
        osmolality: null,
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
      this.title = "添加肝功能生化指标"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const Id = row.id || this.ids
      getBiochemistry(Id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改肝功能生化指标"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.Id != null) {
            updateBiochemistry(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addBiochemistry(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除肝功能生化指标编号为"' + Ids + '"的数据项？').then(function() {
        return delBiochemistry(Ids)
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
  this.download('system/biochemistry/importTemplate', {
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
      this.download('system/biochemistry/export', {
        ...this.queryParams
      }, `biochemistry_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
