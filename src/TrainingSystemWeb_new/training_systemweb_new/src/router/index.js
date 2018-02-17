import Vue from 'vue'
import Router from 'vue-router'
import ListComp from '@/components/ListComp'
import AddComp from '@/components/AddComp'
import ListCourses from '@/components/ListCourses'
import Login from '@/components/Login'
import AddCou from '@/components/AddCou'
import CourseDetails from '@/components/CourseDetails'
import CourseOfCompany from '@/components/CourseOfCompany'
import Index from '@/components/Index'
import UserInfo from '@/components/UserInfo'
import schedule from '@/common/schedule'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    { 
      path: '*', 
      component: Index 
    },
    {
      path: '/ListComp',
      name: 'ListComp',
      component: ListComp,
      title:'List of companys'
    },
    {
      path: '/AddComp',
      name: 'AddComp',
      component: AddComp,
      title:'Create new company'
    },
    {
      path: '/editComp/:name',
      name: 'editComp',
      component: AddComp,
      title:'Edit company'
    },
    {
      path: '/listCourses',
      name: 'ListCourses',
      component: ListCourses
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path:'/addCou',
      name:'AddCou',
      component: AddCou
    },
    {
      path:'/index',
      name:'Index',
      component: Index
    },
    {
      path: '/editCou/:name',
      name: 'EditCou',
      component: AddCou,
      title:'Edit Course'
    },
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/CourseDetails/:compName/:name',
      // path: '/CourseDetails',
      name: 'CourseDetails',
      component: CourseDetails,
      title:'Course Details'
    },
    {
      path: '/CourseOfCompany/:name',
      name: 'CourseOfCompany',
      component: CourseOfCompany
    },
    {
      path: '/UserInfo',
      name: 'UserInfo',
      component: UserInfo
    },
    {
      path: '/schedule',
      name: 'schedule',
      component: schedule
    },
  ]
})
