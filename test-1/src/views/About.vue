<template>
  <div class="about">
    <h5>四则运算</h5>
    <div>
      <el-input type="textarea" :rows="10" v-model="formula"></el-input>
    </div>

    <div>
      <el-button type="primary" v-on:click="verification_formula"
        >验证公式</el-button
      >
    </div>

    <el-dialog
      title="输入参数"
      :visible.sync="dialogTableVisible"
      center
      :append-to-body="true"
      :lock-scroll="false"
      width="30%"
    >
      <div id="input_params">
        <el-row>
          <el-col :span="24" v-for="(list, index) in params" v-bind:key="index">
            <el-row :gutter="20" class="margins">
              <el-col :span="5"> 参数{{ index + 1 }}</el-col>
              <el-col :span="50">
                <el-input
                  type="text"
                  name="param"
                  v-model="paramValues[index]"
                ></el-input>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </div>
      <!--<Update :current_year="current_year" :current_id="current_id"></Update>-->

      <br />
      <div>
        <span>运行结果：</span>
        <span>{{ result }}</span>
      </div>
      <div class="search_button_u">
        <el-button type="primary" v-on:click="calculation()">运行</el-button>

        <el-button type="primary" v-on:click="cancel()">关闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "About",
  props: {
    year: Number,
    msg: String
  },
  data() {
    return {
      formula: "",
      dialogTableVisible: false,
      firstParam: [],
      status: false,
      params: [],
      paramValues: [],
      result: ""
    };
  },
  methods: {
    verification_formula() {
      //document.getElementById("input_params").innerHTML = "";
      //(${参数1} + ${参数2} + ${参数3} - ${参数4})/(${参数5} + ${参数6})
      var params = this.formula.split("$");
      if (params[0].indexOf("$") === -1) {
        this.firstParam = params.splice(0, 1);
        this.status = true;
      }
      this.params = params;
      console.log(params);
      this.dialogTableVisible = true;
      /*let html = "";
				if (this.formula.indexOf("$") === 0) {
				  for (var i = 0; i < params.length; i++) {
				    let param = params[i].replace(/$/g, "");
				    param = param.replace(/\(/g, "");
				    param = param.replace(/\)/g, "");
				    param = param.replace(/}/g, "");
				    param = param.replace(/{/g, "");
				    param = param.replace(/[-+*!/]？/g, "");
				    html +=
				      "<label>" +
				      param +
				      '</label><el-input v-model="param' +
				      i +
				      '"></el-input>';
				    html += "<br>";
				  }
				} else {
				  for (var j = 1; j <= params.length; j++) {
				    let param_e = params[j].replace(/$/g, "");
				    param_e = param_e.replace(/\(/g, "");
				    param_e = param_e.replace(/\)/g, "");
				    param_e = param_e.replace(/}/g, "");
				    param_e = param_e.replace(/{/g, "");
				    param_e = param_e.replace(/[-+*!/]？/g, "");
				    html +=
				      "<label>" +
				      param_e +
				      '</label><el-input v-model="param' +
				      j +
				      '"></el-input>';
				    html += "<br>";
				  }
				}
				console.log(html);
				this.dialogTableVisible = true;
				document.getElementById("input_params").innerHTML = html;
				let str = "1+6";
				try {
				  let ret = eval(str);
				  console.log(ret);
				  if (ret !== Infinity) {
				    alert("right");
				  } else {
				    alert("wrong");
				  }
				} catch (e) {
				  alert("wrong");
				}*/
    },
    calculation() {
      console.log(this.paramValues);
      this.$http
        .put("/calculation/", {
          params: this.params,
          firstParam: this.firstParam,
          status: this.status,
          paramValues: this.paramValues
        })
        .then(res => {
          if (res.data.code === 10000) {
            this.result = res.data.data;
          } else {
            this.result = res.data.description;
          }
        });
    },
    cancel() {
      this.dialogTableVisible = false;
    }
  }
};
</script>
<style>
.search_button_u {
  margin: 5px 10px 5px 10px;
}
</style>
