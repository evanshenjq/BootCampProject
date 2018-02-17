import { destroyVM, createTest, createVue } from './util'
import Login from '../../../src/components/Login.vue'
import Vue from 'vue'
import $ from 'jquery'


describe('Login.vue', () => {
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
          vm = createTest(Login, {}, true)


      });

    it('test submit_button', () => {
      const buttonDelete = vm.$el.querySelector('#submit_button')
      const clickEvent = new window.Event('click')
      buttonDelete.dispatchEvent(clickEvent)
      // 需要手动监听更新
      vm._watcher.run()

    })
})
