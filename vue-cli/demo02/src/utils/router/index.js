/*
라우터 모듈 만들기
- 이곳에 필요한 라우터 객체와 설정을 다 작성
- 외부에 필요한 요소만 공개(export)
     - default export를 할 것인지
     - named export를 할 것인지(권장)

createWebHistory
- 루트 : http://localhost:8080/
- 정보 : http://localhost:8080/info
    - 페이지가 각자 다른 주소를 가짐
    - 서버에서 모든 페이지를 다 개방해야 접속이 가능
    - GitHub Page와 같이 루트주소만 사용 가능한 경우 불가능한 방식
    - 검색엔진 최적화(SEO)이 가능


createWebHashHistory
- 루트 : http://localhost:8080/#/
- 정보 : http://localhost:8080/#/info
    - 페이지가 모두 같은 주소를 가짐
    - 검색엔진에서 한페이지로 인식하므로 정상적인 검색이 불가능
    - 보안 정책상 한 페이지만 허용 가능할 때 사용하면 좋다
*/
import { createRouter, createWebHashHistory} from "vue-router";
import MainContent from "@/components/MainContent.vue";
import DevInfo from "@/components/DevInfo.vue"

// 라우터 생성
const router = createRouter({
    
    // 이력(주소) 관리 방식
    history:createWebHashHistory(),

    // url 주소에 # 없어짐
    // history:createWebHistory(),
    
    // 실제 라우터가 연결해줄 주소와 컴포넌트 명단
    routes:[
        
        // 주소 (/)로 들어올 경우 컴포넌트 (MainContent.vue)를 표시한다.
        // 수동으로 MainContent를 import해야함
        {path:"/", component:MainContent},

        // 주소 (info)로 들어올 경우 컴포넌트 (DevInfo.vue)를 표시한다
        {path:"/info", component:DevInfo},
    ],
});




// 외부에 공개 설정(named export)
export {router};
// export default router;

