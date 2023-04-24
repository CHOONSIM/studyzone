<template>
  <div class="header">
      <h1>{{ title }}</h1>
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