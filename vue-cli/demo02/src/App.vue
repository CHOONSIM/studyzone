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

    <!-- 
        vuex에 있는 state의 loading이 true라면 vue-spinner가 나오도록 설정
        - App.vue에 설정하면 모든 화면에서 동일하게 나온다
        - vuex에 설정된 getters의 isLoading에 따라 처리되도록 구현

        - 반환 : this.$store.getter.이름 or this.$store.getters["이름"]

        - 설정 : this.$store.commit("이름") or this.$store.commit("이름",데이터)
    -->
    
    <PulseLoader :loading="$store.getters.isLoading"/>
    
  </div>
</template>
 
<script>
import MainHeader from './components/MainHeader.vue';
import MainFooter from './components/MainFooter.vue';
import PulseLoader from 'vue-spinner/src/PulseLoader.vue';

export default {
  //components에서는 사용할 화면 조각(vue)를 정의한다
  components:{
    MainHeader, 
    MainFooter,
    PulseLoader,

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
<style scoped>
  .v-spinner {
    position: fixed;
    top:50%;
    left:50%;
    transform: translate(-50%, -50%);
  }
</style>