import { destroyVM, createTest, createVue } from './util'
import ListCourse from '../../../src/components/ListCourse.vue'
import Vue from 'vue'
import $ from 'jquery'

describe('ListCourse.vue', () => {
  let vm
  afterEach(() => {
    destroyVM(vm)
  })
  beforeEach(function () {
      vm = createTest(ListCourse, {}, true)
      spyOn(vm, 'getAllData');

  });


  it('tracks calls', function () {
  vm.getAllData(1)
      expect(vm.$el.querySelector('.jumbotron h1').textContent).toEqual('Hello, world!')
    //  console.log(companyId)
      expect(vm.getAllData).toHaveBeenCalledWith(1);
  });
 })
