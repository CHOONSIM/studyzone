import { createApp } from 'vue'
import App from './App.vue'

// bootstrap css를 전체에서 사용 가능하도록 불러온다
// import "bootstrap/dist/css/bootstrap.min.css";

// bootswatch css 불러오기
import "bootswatch/dist/lux/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js"



// 이미 개발된 라우터 모듈을 불러오도록 구현(index.js는 경로에서 생략 가능)
import {router} from './utils/router'
// import {router} from './utils/router/index.js'

// 애플리케이션 생성 코드
// - 라우터를 사용하도록 설정해야함(use 함수 사용)
createApp(App).use(router).mount('#app')
 
