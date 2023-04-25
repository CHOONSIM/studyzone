/*
    vue에서 사용할 전역 저장소(global Storage) 설정

    npm install vuex

    Vue에 use 설정을 하게되면 아무데서나 다음과 같이 접근이 가능

    this.$store

    만약 로그인을 구현하는 경우 서버의 세션ID를 불러와서 저장하고
    매 통신마다 데이터에 포함하여 전송한다.

    서버에서 전달받은 세션번호와 현재 세션이 일치하는지 검사하고 CRUD를 처리
*/

import { createStore } from "vuex";

//vuex 옵션
/*
    state는 실직적인 데이터를 소유하는 공간(ex : 은행금고)
    getters는 state에 대한 computed 공간(ex : ATM,꺼내는 용도)
    mutations은 state에 대한 변화를 발생하는 공간(ex : 은행원)
    actions는 mutation을 비동기로 실행하는 공간(ex : 은행어플)

    스프링으로 비교하자면 HttpSession 역할을 할 수 있음

*/
const options = {
    state:{
        // 애플리케이션에서 데이터 로딩 상태 여부를 저장
        loading:false,
    },
    getters:{
        isLoading(state){
            // 매개변수에 state를 선언하여 사용하도록 설계되어 있음
            return state.loading;
        },
    },
    mutations:{
        // 매개변수에 state를 선언하여 사용하도록 설계되어 있음
        startLoading(state){
            state.loading = true;
        },
        finishLoading(state){
            state.loading = false;
        },
    },
    actions:{}
};
// 저장소
const storage = createStore(options);

export {storage};