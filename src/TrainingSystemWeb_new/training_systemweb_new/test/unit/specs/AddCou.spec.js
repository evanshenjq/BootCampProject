import { destroyVM, createTest, createVue } from './util'
import AddCou from '../../../src/components/AddCou.vue'
import Vue from 'vue'
import $ from 'jquery'
describe('AddCou.vue', () => {
    let vm
    afterEach(() => {
      destroyVM(vm)
    })
    beforeEach(function () {
        vm = createTest(AddCou, {}, true)
 //       spyOn(vm, 'getAllData');

    });

 
   it('test saveButton ', () => {


  // expect($j('#window')).not.toBeInDOM()
     //addOrg.orgName = 'testinputname'
     const button = vm.$el.querySelector('#saveButton')
     const clickEvent = new window.Event('click')
     button.dispatchEvent(clickEvent)
     // 需要手动监听更新
     vm._watcher.run()

     //expect(addOrg.$el.querySelector('.form-control').textContent).toEqual('testinputname')
    // expect(addOrg.$el.querySelector('.mymodal').textContent).toEqual("saf")
   })

 it('test saveButton as showCouNameError is false ', () => {


  // expect($j('#window')).not.toBeInDOM()
     //addOrg.orgName = 'testinputname'
     vm.showCouNameError = false
     const button = vm.$el.querySelector('#saveButton')
     const clickEvent = new window.Event('click')
     button.dispatchEvent(clickEvent)
     // 需要手动监听更新
     vm._watcher.run()

     //expect(addOrg.$el.querySelector('.form-control').textContent).toEqual('testinputname')
    // expect(addOrg.$el.querySelector('.mymodal').textContent).toEqual("saf")
   })

  // 检查msg
   it('test closeButton ', () => {

  // expect($j('#window')).not.toBeInDOM()
     //addOrg.orgName = 'testinputname'
     const button = vm.$el.querySelector('#closeButton')
     const clickEvent = new window.Event('click')
     button.dispatchEvent(clickEvent)
     // 需要手动监听更新
     vm._watcher.run()

     //expect(addOrg.$el.querySelector('.form-control').textContent).toEqual('testinputname')
    // expect(addOrg.$el.querySelector('.mymodal').textContent).toEqual("saf")
   })


  
   it('test change orgName as orgName length is 0 ', () => {
	vm.orgName = "    "
 	expect(vm.orgName).toEqual("    ")
    // expect(addOrg.$el.querySelector('.mymodal').textContent).toEqual("saf")
   })

 
   it('test change orgName as orgName length is not 0 ', () => {
	vm.orgName = " fsfsd"
 	expect(vm.orgName).toEqual(" fsfsd")
    // expect(addOrg.$el.querySelector('.mymodal').textContent).toEqual("saf")
   })


   it('test change orgName as logoUrl is not null ', () => {
	vm.logoUrl = ""
 	expect(vm.logoUrl).toEqual("")
    // expect(addOrg.$el.querySelector('.mymodal').textContent).toEqual("saf")
   })

 
   it('test change orgName as logoUrl is null ', () => {
	vm.logoUrl = "fsfsd"
 	expect(vm.logoUrl).toEqual("fsfsd")
    // expect(addOrg.$el.querySelector('.mymodal').textContent).toEqual("saf")
   })


   it('test add time ', () => {
	vm.box1S = "8:00"
	vm.box1E = "8:15"

	const button = vm.$el.querySelector('#addButton')
	const clickEvent = new window.Event('click')
	button.dispatchEvent(clickEvent)
    // 需要手动监听更新
	vm._watcher.run()
    // expect(addOrg.$el.querySelector('.mymodal').textContent).toEqual("saf")
   })



// 检查msg
   it('test change orgName ', () => {
	vm.orgName = "    "
 	expect(vm.orgName).toEqual("    ")
    // expect(addOrg.$el.querySelector('.mymodal').textContent).toEqual("saf")
   })
    // let vm

    // afterEach(() => {
    //   destroyVM(vm)
    // })

    // it('测试获取元素内容', () => {
    //   vm = createTest(addOrg, {}, true)
    //   vm.save()
    //   expect(vm.$el.querySelector('.modal-header').hidden).not.toBeTruthy()
    //   expect(vm.$el.querySelector('.modal-body').hidden).not.toBeTruthy()
    //   expect(vm.$el.querySelector('.modal-footer').hidden).not.toBeTruthy()
    //   expect(vm.$el.querySelector('.btn-primary').hidden).not.toBeTruthy()
    //   expect(vm.$el.querySelector('.btn-warning').hidden).not.toBeTruthy()

    //   //   expect(vm.$el.querySelector('.hello h2').textContent).toEqual('Hello World')
    //   const text = vm.$el.querySelector('#myModalLabel').textContent
    //   expect(text.trim(text)).toEqual("hello")
    // })


  })
