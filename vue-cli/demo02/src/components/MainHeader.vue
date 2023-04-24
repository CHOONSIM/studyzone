<template>
  <div class="header">

      <!--
        메뉴 구현
          - 메뉴를 누르면 <RouterView/>가 변해야 한다
          - 일반적인 a태그로는 연결하기가 어렵다(Hash여부를 알 수 없음)
          - <RouterView/> 에 연결하기 위해서는 <RouterLink/>를 사용한다
            - to 속성에 이동할 주소를 작성
            - / 가 절대경로 시작점을 의미
            - v-bind가 붙으면 동적으로 설정 가능
      -->
      <!-- 메뉴 구현 -->
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
  <div class="container-fluid">
    <RouterLink class="navbar-brand" to="/">KHacademy</RouterLink>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <RouterLink class="nav-link" to="/pocketmon">Pocketmon</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink class="nav-link" to="/subject">Subject</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink class="nav-link" to="info">About</RouterLink>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Separated link</a>
          </div>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-sm-2" type="search" placeholder="Search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

  </div>
</template>

<script>
export default {
  //외부에서 불려질 이름(태그명)
  name:"MainHeader",
  //상위 태그에서 전달한 값 중 사용할 값을 선언
  //props:[title]
  props:{
      title:String
  },
  data(){
      return {
          
      }; 
  },
};
</script>

<style>
</style>