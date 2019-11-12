<template>
  <div id="app">
    <!--    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/about1">About1</router-link> |
      <router-link to="/about2">About2</router-link>
    </div>
    <router-view />-->

    <el-tabs type="border-card" v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="问题1" name="first"><tabe1 /></el-tab-pane>
      <el-tab-pane label="问题2" name="second"><tabe2 /></el-tab-pane>
      <el-tab-pane label="问题3" name="third"><tabe3 /></el-tab-pane>
      <el-tab-pane label="问题4" name="fourth"><tabe4 /></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import Tabe1 from "@/views/Home";
import Tabe2 from "@/views/About";
import Tabe3 from "@/views/About1";
import Tabe4 from "@/views/About2";
export default {
  name: "Tabe",
  data() {
    return {
      activeName: "first"
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  },
  //页面标签化
  components: {
    tabe1: Tabe1,
    tabe2: Tabe2,
    tabe3: Tabe3,
    tabe4: Tabe4
  }
};
</script>

<style lang="scss">
#app {
  margin: 50px 150px 50px 150px;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
