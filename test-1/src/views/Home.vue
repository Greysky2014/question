<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png" />-->
    <!--<HelloWorld msg="Welcome to Your Vue.js App" />-->
    <QuestionOne></QuestionOne>
  </div>
</template>

<script>
// @ is an alias to /src
import QuestionOne from "@/components/QuestionOne.vue";

export default {
  name: "home",
  components: {
    QuestionOne
  }
};
</script>
