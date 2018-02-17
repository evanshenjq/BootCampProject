import { destroyVM, createTest, createVue } from './util'
import ListTable from '../../../src/components/ListTable.vue'
import Vue from 'vue'
import $ from 'jquery'
import Router from 'vue-router'

Vue.use(Router)
describe('ListTable.vue', () => {
    // 组件实例
   let vm;

    // // 检查orgs
    // it('Orgs should in page', () => {
    //   org = listTable.orgs.get(0)
    //   const orgName = org.$el.querySelector('.col-md-5')
    // })

    // //test create()
    // it('msg should in page', () => {
    //   const buttonCreate = listTable.$el.querySelector('#createButton')
    //   const clickEvent = new window.Event('click')
    //   button.dispatchEvent(clickEvent)
    //   // 需要手动监听更新
    //   listTable._watcher.run()

    //   expect(listTable.$el.textContent).to.contain('bye bye')
    // })

    //test del()

     afterEach(() => {
        destroyVM(vm)
      })
      beforeEach(function () {
          vm = createTest(ListTable, {}, true)
          spyOn(vm, 'search');

      });

    it('test del', () => {
      const buttonDelete = vm.$el.querySelector('#delButton')
      const clickEvent = new window.Event('click')
      buttonDelete.dispatchEvent(clickEvent)
      // 需要手动监听更新
      vm._watcher.run()
      expect(vm.orgs.length).toEqual(jasmine.any(Number));
    })


    //test search()
    it('test search', () => {
      const buttonSearch = vm.$el.querySelector('#search')
      const clickEvent = new window.Event('click')
      buttonSearch.dispatchEvent(clickEvent)
      // 需要手动监听更新
      vm._watcher.run()
     // vm.search()
      expect(vm.search).toHaveBeenCalled();
      expect(vm.orgs.length).toEqual(jasmine.any(Number));
    })

      //test edit()
        it('test edit', () => {
          const buttonEdit = vm.$el.querySelector('#selAllDiv')
          const clickEvent = new window.Event('click')
          buttonEdit.dispatchEvent(clickEvent)
          // 需要手动监听更新
          vm._watcher.run()
         // vm.search()

          expect(vm.orgs.length).toEqual(jasmine.any(Number));
        })

         //test Createbtn
          it('test Createbtn', () => {
            const buttonCreate = vm.$el.querySelector('#createButton')
            const clickEvent = new window.Event('click')
            buttonCreate.dispatchEvent(clickEvent)
            // 需要手动监听更新
            vm._watcher.run()
           // vm.search()

            expect(vm.orgs.length).toEqual(jasmine.any(Number));
          })

    it('test getAllData',()=>{
      let vm = new Vue(ListTable).$mount();
      expect(vm.nowPage).toEqual(0);
    })

})
