/*
    프로젝트 전체에서 사용할 axios 모듈을 선언
*/

// 우선 라이브러리로 설치한 axios를 불러온다
import axios from "axios";

// vuex를 사용할 수 있도록 불러온다
/* 
    - 사용법
        - 확인(getters) - stoarge.getters.이름 or storage.getters["이름"]
        - 변경(mutations) - storage.commit("이름") or storage,commit("이름", 데이터)
*/ 
import { storage } from "../vuex";


// 원하는 작업을 axios에 추가한다

// 요청 인터셉터 추가하기
axios.interceptors.request.use(function (config) {
    // 요청이 전달되기 전에 작업 수행
    // console.log("통신 발생 전")

    // vuex의 mutation 중 finishLoading을 실행하세요
   storage.commit("startLoading");
   
    return config;
}, function (error) {
    // 요청 오류가 있는 작업 수행
    // console.log("통신 발생 불가")

   // vuex의 mutation 중 finishLoading을 실행하세요
   storage.commit("finishLoading");
    return Promise.reject(error);
});

// 응답 인터셉터 추가하기
axios.interceptors.response.use(function (response) {
    // 2xx 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    // 응답 데이터가 있는 작업 수행
    // console.log("서버 응답 성공")

    // vuex의 mutation 중 finishLoading을 실행하세요
    storage.commit("finishLoading");

    return response;
}, function (error) {
    // 2xx 외의 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    // 응답 오류가 있는 작업 수행
    // console.log("서버 응답 실패")

    // vuex의 mutation 중 finishLoading을 실행하세요
    storage.commit("finishLoading");
    return Promise.reject(error);
});

// 외부에서 사용할 수 있도록 내보낸다
export {axios};