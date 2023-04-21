const a =100;
const b =200;
const c =300;

export {a,b}; //a를 내보내겠다.

const student = {
    name: "테스트",
    score:90
};

export{student};    //student를 내보내겠다(named export)
export default student; //student를 기본값으로 내보내겠다