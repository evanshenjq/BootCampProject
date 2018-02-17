import { destroyVM, createTest, createVue } from './util'
import Modal from '../../../src/common/Modal.vue'
import Vue from 'vue'
import $ from 'jquery'
describe('Modal.vue', () => {
  let vm

  afterEach(() => {
    destroyVM(vm)
  })

  it('测试获取元素内容', () => {
    vm = createTest(Modal, {}, true)
    expect(vm.$el.querySelector('.modal-header').hidden).not.toBeTruthy()
    expect(vm.$el.querySelector('.modal-body').hidden).not.toBeTruthy()
    expect(vm.$el.querySelector('.modal-footer').hidden).not.toBeTruthy()
    expect(vm.$el.querySelector('.btn-primary').hidden).not.toBeTruthy()
    expect(vm.$el.querySelector('.btn-warning').hidden).not.toBeTruthy()

    //   expect(vm.$el.querySelector('.hello h2').textContent).toEqual('Hello World')
    const text = vm.$el.querySelector('#myModalLabel').textContent
    expect(text.trim(text)).toEqual("hello")
  })

  // it('测试获取元素内容', () => {
  //   vm = createTest(Modal, {}, true)
  //  // console.log(vm.showMyModal)
  //   vm.showMyModal
  //   // expect(vm.$el.querySelector('.modal-header').hidden).not.toBeTruthy()
  //   // expect(vm.$el.querySelector('.modal-body').hidden).not.toBeTruthy()
  //   // expect(vm.$el.querySelector('.modal-footer').hidden).not.toBeTruthy()
  //   // expect(vm.$el.querySelector('.btn-primary').hidden).not.toBeTruthy()
  //   // expect(vm.$el.querySelector('.btn-warning').hidden).not.toBeTruthy()

  //   //   expect(vm.$el.querySelector('.hello h2').textContent).toEqual('Hello World')
  //   const text = vm.$el.querySelector('#myModalLabel').textContent
  //   expect(text.trim(text)).toEqual("hello")
  // })

  // it('测试showMyModal方法', () => {
  //   vm = createVue({
  //    template: `
  //     <click @click="testShow"></click>
  //       <modal ref="myModal"></modal>
  //     `,
  //     methods: {
  //       testShow() {
  //         this.$refs.myModal.showMyModal(
  //           true,
  //           true,
  //           true,
  //           false,
  //           true,
  //           "Warning",
  //           "Name is required!",
  //           "",
  //           "OK"
  //         );
  //       }
  //     },
  //     components: {
  //       Modal
  //     }
  //   },true)
  //   vm.testShow()
  // })


})