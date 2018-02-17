import { destroyVM, createTest, createVue } from './util'
import AddOrg from '../../../src/components/AddOrg.vue'
import Vue from 'vue'
import $ from 'jquery'
describe('addOrg.vue', () => {
  let vm
    afterEach(() => {
      destroyVM(vm)
    })
    beforeEach(function () {
        vm = createTest(AddOrg, {}, true)
 //       spyOn(vm, 'getAllData');

    });

 

  // 检查msg
  it('msg should in page', () => {


 // expect($j('#window')).not.toBeInDOM()
    vm.orgName = 'testinputname'
    const button = vm.$el.querySelector('#saveButton')
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

  })
