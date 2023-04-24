<template>
  <div>
    <!-- 헤더 -->
    <!-- <MainHeader title="KH정보교육원 프론트엔드 수업자료"/> -->
    <!-- <MainHeader v-bind:title="title"/> -->
    <MainHeader :title="title"/>

    <!-- 
      여러 개의 페이지 중에서 골라야 한다면 컴포넌트를 직접 작성하면 안된다.
      <RouterView/>라는 도구를 이용해서 이 자리는 router 설정에 따른 화면이 나온다는 것을 표시
     -->
    <RouterView/>

    <!-- 푸터 -->
    <MainFooter/>
    
  </div>
</template>
 
<script>
import MainHeader from './components/MainHeader.vue';
import MainFooter from './components/MainFooter.vue';
export default {
  //components에서는 사용할 화면 조각(vue)를 정의한다
  components:{
    MainHeader, 
    MainFooter
  },
  //data에서는 현재 컴포넌트에서 사용할 데이터를 정의한다
  data(){
    return {
      title:"KH정보교육원 프론트엔드 수업자료",
    };
  },
};
</script>

<!-- 
    style을 사용할 때 전체스타일과 컴포넌트 스타일을 구분할 수 있다 
    - <style> 로 만들면 전체 스타일이 된다
    - <style scoped> 로 만들면 컴포넌트 전용 스타일이 된다
-->
<style>
</style>