/*
    프로젝트 전체에서 사용할 axios 모듈을 선언
*/

// 우선 라이브러리로 설치한 axios를 불러온다
import axios from "axios";

// 원하는 작업을 axios에 추가한다

// 요청 인터셉터 추가하기
axios.interceptors.request.use(function (config) {
    // 요청이 전달되기 전에 작업 수행
    console.log("통신 발생 전")
    //loading=true;
    return config;
}, function (error) {
    // 요청 오류가 있는 작업 수행
    console.log("통신 발생 불가")
    //loading=false;
    return Promise.reject(error);
});

// 응답 인터셉터 추가하기
axios.interceptors.response.use(function (response) {
    // 2xx 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    // 응답 데이터가 있는 작업 수행
    console.log("서버 응답 성공")
    //loading=false;
    return response;
}, function (error) {
    // 2xx 외의 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    // 응답 오류가 있는 작업 수행
    console.log("서버 응답 실패")
    //loading=false;
    return Promise.reject(error);
});

// 외부에서 사용할 수 있도록 내보낸다
export {axios};