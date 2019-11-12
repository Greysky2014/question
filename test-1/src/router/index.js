import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/home",
    name: "home",
    component: Home
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  },
  {
    path: "/about1",
    name: "about1",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About1.vue")
  },
  {
    path: "/about2",
    name: "about2",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About2.vue")
  },
  {
    path: "/addApply",
    name: "addApply",
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/AddApply.vue")
  },
  {
    path: "/",
    name: "addApply",
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/AddApply.vue")
  },
  {
    path: "/applyList",
    name: "applyList",
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/ApplyList.vue")
  },
  {
    path: "/flowChart",
    name: "flowChart",
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/FlowChart.vue")
  }
];

const router = new VueRouter({
  routes
});

export default router;
