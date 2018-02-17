import Vue from 'vue'
import App from './App'
import router from './router'
import $ from 'jquery'
import BootstrapVue from 'bootstrap-vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'
import 'whatwg-fetch'
import Vuex from 'vuex'
import { mapMutations } from 'vuex'
import 'vue-event-calendar/dist/style.css'
import vueEventCalendar from 'vue-event-calendar'


Vue.use(Vuex)
require('es6-promise').polyfill()

Vue.use(BootstrapVue);
Vue.use(ElementUI);
Vue.use(vueEventCalendar, {locale: 'en',color: '#6E6E6E'}) 


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App),
  template: '<App/>',
  components: { App }
})

Vue.prototype.session= (function($){$.session={_id:null,_cookieCache:undefined,_init:function()  
  {if(!window.name){window.name=Math.random();}  
  this._id=window.name;this._initCache();var matches=(new RegExp(this._generatePrefix()+"=([^;]+);")).exec(document.cookie);if(matches&&document.location.protocol!==matches[1]){this._clearSession();for(var key in this._cookieCache){try{window.sessionStorage.setItem(key,this._cookieCache[key]);}catch(e){};}}  
  document.cookie=this._generatePrefix()+"="+ document.location.protocol+';path=/;expires='+(new Date((new Date).getTime()+ 120000)).toUTCString();},_generatePrefix:function()  
  {return'__session:'+ this._id+':';},_initCache:function()  
  {var cookies=document.cookie.split(';');this._cookieCache={};for(var i in cookies){var kv=cookies[i].split('=');if((new RegExp(this._generatePrefix()+'.+')).test(kv[0])&&kv[1]){this._cookieCache[kv[0].split(':',3)[2]]=kv[1];}}},_setFallback:function(key,value,onceOnly)  
  {var cookie=this._generatePrefix()+ key+"="+ value+"; path=/";if(onceOnly){cookie+="; expires="+(new Date(Date.now()+ 120000)).toUTCString();}  
  document.cookie=cookie;this._cookieCache[key]=value;return this;},_getFallback:function(key)  
  {if(!this._cookieCache){this._initCache();}  
  return this._cookieCache[key];},_clearFallback:function()  
  {for(var i in this._cookieCache){document.cookie=this._generatePrefix()+ i+'=; path=/; expires=Thu, 01 Jan 1970 00:00:01 GMT;';}  
  this._cookieCache={};},_deleteFallback:function(key)  
  {document.cookie=this._generatePrefix()+ key+'=; path=/; expires=Thu, 01 Jan 1970 00:00:01 GMT;';delete this._cookieCache[key];},get:function(key)  
  {return window.sessionStorage.getItem(key)||this._getFallback(key);},set:function(key,value,onceOnly)  
  {try{window.sessionStorage.setItem(key,value);}catch(e){}  
  this._setFallback(key,value,onceOnly||false);return this;},'delete':function(key){return this.remove(key);},remove:function(key)  
  {try{window.sessionStorage.removeItem(key);}catch(e){};this._deleteFallback(key);return this;},_clearSession:function()  
  {try{window.sessionStorage.clear();}catch(e){for(var i in window.sessionStorage){window.sessionStorage.removeItem(i);}}},clear:function()  
  {this._clearSession();this._clearFallback();return this;}};$.session._init();})(jQuery); 

// router.start(App, '#app')
