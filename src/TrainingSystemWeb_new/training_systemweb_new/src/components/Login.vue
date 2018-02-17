<template>
  <div>
			<modal ref="myModal"></modal>
      <h1 class="col-sm-offset-1">Login</h1>
      <form class="form-horizontal" id="login_form">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-3">
              <input type="text" class="form-control" id="input_Username" placeholder="Username" name="username">
            </div>
          </div>
          <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-3">
              <input type="password" class="form-control" id="input_Password" placeholder="Password" name="password" @keyup.enter="cilickLogin">
              <div id="login_info"></div>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button type="button" class="btn btn-default" id="submit_button" @click="cilickLogin">Login</button>
            </div>
          </div>
        </form>

  </div>
</template>

<script src="@/assets/js/login.js"></script>

<style src="@/assets/sass/login.scss" scoped></style>
