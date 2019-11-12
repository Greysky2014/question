<template>
  <div>
    <div>
      <div class="one_search div_inline">
        <label>
          年度
        </label>
        <el-input
          label="年度"
          v-model="year"
          placeholder="请输入查询的年度"
          clearable
          class="one_input"
        ></el-input>
      </div>
      <div class="search_button div_inline">
        <el-button type="primary" v-on:click="question_search()"
          >查询</el-button
        >
      </div>
    </div>
    <!-- 表格 -->
    <div>
      <el-table
        :data="tableData"
        style="width: 100%;margin-left: 60px"
        @cell-click="openDetails"
      >
        <el-table-column
          prop="year"
          label="年度"
          width="200"
          :formatter="formatYear"
        >
        </el-table-column>
        <el-table-column
          prop="duration"
          label="期间"
          width="200"
          :formatter="formatYearMonth"
        >
        </el-table-column>
        <el-table-column
          prop="startDate"
          label="起始日期"
          width="200"
          :formatter="formatStartDate"
        >
        </el-table-column>
        <el-table-column
          prop="endTime"
          label="结束日期"
          width="200"
          :formatter="formatEndDate"
        >
        </el-table-column>
        <el-table-column prop="status" label="状态" :formatter="formatType">
        </el-table-column>
      </el-table>
    </div>
    <el-dialog
      title="修改数据"
      :visible.sync="dialogTableVisible"
      center
      :append-to-body="true"
      :lock-scroll="false"
      width="30%"
    >
      <!--<Update :current_year="current_year" :current_id="current_id"></Update>-->
      <div>
        <div class="one_search_u div_inline_u">
          <el-input
            v-model="current_year"
            clearable
            class="one_input_u"
          ></el-input>
        </div>
        <div class="search_button_u div_inline_u">
          <el-button type="primary" v-on:click="question_update()"
            >确定</el-button
          >

          <el-button type="primary" v-on:click="question_cancel()"
            >取消</el-button
          >
        </div>
        <div>
          <span id="question_show"></span>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
//import Update from "./Update.vue";
export default {
  name: "QuestionOne",
  props: {
    year: Number,
    msg: String
  },
  data() {
    return {
      tableData: [],
      dialogTableVisible: false,
      current_year: 2019,
      current_id: 0
    };
  },
  methods: {
    question_search() {
      console.log(this.year);
      this.$http.get("/questionOne/" + this.year).then(res => {
        this.tableData = res.data.data;
      });
    },
    updateData(row, column, event) {
      alert("0000000");
      console.log(JSON.stringify(row));
      console.log(JSON.stringify(column));
      console.log(JSON.stringify(event));
    },
    showData(row, column, cell, event) {
      alert("1111");
      console.log(JSON.stringify(row));
      console.log(JSON.stringify(column));
      console.log(JSON.stringify(event));
    },
    formatYear(val) {
      console.log(val.year);
      let datetime = val.year;
      if (datetime) {
        datetime = new Date(datetime);
        let y = datetime.getFullYear();
        return y;
      }
      return "";
    },
    formatYearMonth(val) {
      console.log(val.duration);
      let duration = val.duration;
      if (duration) {
        duration = new Date(duration);
        let y = duration.getFullYear() + "-";
        let mon = duration.getMonth() + 1;
        if (mon < 10) {
          return y + "0" + mon;
        } else {
          return y + mon;
        }
      }
      return "";
    },
    formatStartDate(val) {
      console.log(val.startDate);
      let datetime = val.startDate;
      if (datetime) {
        datetime = new Date(datetime);
        let y = datetime.getFullYear() + "-";
        let mon = datetime.getMonth() + 1;
        if (mon < 10) {
          mon = "0" + mon + "-";
        } else {
          mon = mon + "-";
        }
        let d = datetime.getDate();
        console.log(d);
        if (d < 10) {
          d = "0" + d;
        }
        console.log(d);
        return y + mon + d;
      }
      return "";
    },
    formatEndDate(val) {
      console.log(val.endTime);
      let datetime = val.endTime;
      if (datetime) {
        datetime = new Date(datetime);
        let y = datetime.getFullYear() + "-";
        let mon = datetime.getMonth() + 1;
        if (mon < 10) {
          mon = "0" + mon + "-";
        } else {
          mon = mon + "-";
        }
        let d = datetime.getDate();
        if (d < 10) {
          d = "0" + d;
        }
        return y + mon + d;
      }
      return "";
    },
    formatType(row) {
      console.log(row.status);
      let status = row.status;
      if (status) {
        if (status === 1) {
          return "已关闭";
        } else if (status === 2) {
          return "打开";
        } else {
          return "未打开";
        }
      }
      return "";
    },
    getAllQuestionOne() {
      this.$http.get("/questionOne/").then(res => {
        //alert(JSON.stringify(res));
        this.tableData = res.data.data;
      });
    },
    openDetails(row,column, cell) {
      //confirm(this.formatYear(row) + "" + row.id);
      console.log(cell);
      console.log(row.id + " 年：" + this.formatYear(row));
      this.dialogTableVisible = true;
      this.current_id = row.id;
      //this.current_year = this.formatYear(row);
      this.current_year = cell.innerText;
    },
    question_update() {
      console.log(this.current_year);
      let numReg = /^[0-9]+$/;
      let numRe = new RegExp(numReg);
      if (numRe.test(this.current_year)) {
        document.getElementById("question_show").innerHTML = "";
        this.$http
          .put("/questionOne/update", {
            id: this.current_id,
            year: this.current_year
          })
          .then(res => {
            if (res.data.code === 10000) {
              this.dialogTableVisible = false;
              this.getAllQuestionOne();
            }
          });
      } else {
        document.getElementById("question_show").innerHTML = "请输入正确的年份";
      }
    },
    question_cancel() {
      this.dialogTableVisible = false;
    }
  },
  created() {
    this.getAllQuestionOne();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.one_input {
  width: 200px;
}
.one_search {
  text-align: left;
  margin: 0 500px 0 0;
}
.search_button {
  margin-left: 150px;
  text-align: right;
}
.div_inline {
  display: inline;
}

.one_input_u {
  width: 150px;
}
.one_search_u {
  text-align: left;
  margin: 0 20px 0 0;
}
.search_button_u {
  margin-left: 20px;
  text-align: right;
}
.div_inline_u {
  display: inline;
}
#question_show {
  color: red;
}
</style>
