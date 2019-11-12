<template>
  <div class="about">
    <h1>流程添加</h1>
    <div class="input_apply">
      <label>用户ID</label>
      <el-input
        label="用户ID"
        v-model="user_id"
        placeholder="请输入用户ID"
        clearable
        class="one_input"
      ></el-input>
      <br />
      <label>金额</label>
      <el-input
        label="金额"
        v-model="money"
        placeholder="金额"
        clearable
        class="one_input1"
      ></el-input>

      <br />
    </div>
    <div class="search_button">
      <el-button type="primary" v-on:click="add_apply()">启动流程</el-button>
    </div>
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
      user_id: "",
      money: 0
    };
  },
  methods: {
    add_apply() {
      if (isNaN(this.money)) {
        alert("金额不正确");
      }
      this.$http
        .post("/expense/", {
          userId: this.user_id,
          money: this.money
        })
        .then(res => {
          console.log(res.data);
          alert(res.data);
        });
    }
  },
  created() {}
};
</script>

<style scoped lang="scss">
.input_apply {
  margin: 20px 50px 20px 100px;
}

.one_input {
  width: 200px;
}

.one_input1 {
  width: 200px;
}
.search_button {
  margin-left: 150px;
  text-align: right;
}
</style>
