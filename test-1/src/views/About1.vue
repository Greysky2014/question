<template>
  <div class="about">
    <h1>flowable流程</h1>

    <div>
      <div id="nav">
        <router-link to="/addApply">申请</router-link> |
        <router-link to="/applyList">审批管理列表</router-link> |
        <router-link to="/flowChart">流程图</router-link> |
      </div>
      <router-view />
    </div>
  </div>
</template>
