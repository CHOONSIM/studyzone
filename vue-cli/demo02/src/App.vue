<template>
  <div>
    <!-- 헤더 -->
    <!-- <MainHeader title="KH정보교육원 프론트엔드 수업자료"/> -->
    <!-- <MainHeader v-bind:title="title"/> -->
    <MainHeader :title="title"/>

    <!-- 컨텐츠 -->
    <MainContent/>

    <!-- 푸터 -->
    <MainFooter/>
    
  </div>
</template>

<script>
import MainHeader from './components/MainHeader.vue';
import MainContent from './components/MainContent.vue';
import MainFooter from './components/MainFooter.vue';
export default {
  //components에서는 사용할 화면 조각(vue)를 정의한다
  components:{
    MainHeader, 
    MainContent, 
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