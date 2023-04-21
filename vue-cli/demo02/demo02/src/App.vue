<template>
  <div>
    <!--헤더-->
    <MainHeader></MainHeader>

    <!--컨텐츠-->
    <div class="content">
      <h1>VueJS로 만든 홈페이지</h1>
      <img src="http://via.placeholder.com/700x400">
    </div>
    
    <!--푸터-->
    <div class="footer">
      푸터
    </div>
  </div>
</template>

<script>
import MainHeader from './components/MainHeader.vue'

export default{
  //components에서는 사용할 화면조각(vue)를 정의한다.
  components: {MainHeader},

  //data에서는 현재 컴포넌트에서 사용할 데이터를 정의한다
  data(){
    return {
      number:10,
    };
  },

};
</script>

<style>

</style>
