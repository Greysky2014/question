<template>
  <div>
    <div class="one_search div_inline">
      <el-input v-model="current_year" clearable class="one_input"></el-input>
    </div>
    <div class="search_button div_inline">
      <el-button type="primary" v-on:click="question_update()">确定</el-button>

      <el-button type="primary" v-on:click="question_cancel()">取消</el-button>
    </div>
    <div>
      <span id="question_show"></span>
    </div>
  </div>
</template>

<script>
export default {
  name: "Update",
  props: { current_year: Number, current_id: Number },
  data() {
    return {};
  },
  methods: {
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
              this.$router.push({ path: "/" });
            }
          });
      } else {
        document.getElementById("question_show").innerHTML = "请输入正确的年份";
      }
    },
    question_cancel() {
      this.$router.push({ path: "/" });
    }
  }
};
</script>

<style scoped>
.one_input {
  width: 100px;
}
.one_search {
  text-align: left;
  margin: 0 20px 0 0;
}
.search_button {
  margin-left: 20px;
  text-align: right;
}
.div_inline {
  display: inline;
}
#question_show {
  color: red;
}
</style>
