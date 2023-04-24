<template>
    <div class="container-fluid">
        <div class="row">
            <div class="offset-sm-2 col-sm-8 offset-1 col-10">

                <!-- Jumbotron-->
                <div class="row mt-5">
                    <div class="col">
                        <div class="col p-4 bg-dark text-light rounded">
                            <h1>포켓몬 관리 페이지</h1>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>번호</th>
                                    <th>이름</th>
                                    <th>속성</th>
                                </tr>
                            </thead>
                            <tbody v-for="pocketmon in pocketmonList" :key="pocketmon.no">
                                <tr>
                                    <td>{{pocketmon.no}}</td>
                                    <td>{{pocketmon.name}}</td>
                                    <td>{{pocketmon.type}}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
// 이 파일에서만 Axios를 사용하고 싶다면 이곳에서 import를 진행하면 된다
import axios from "axios"; 
console.log(axios);

    export default{
        data(){
            return{
                pocketmonList:[],

            };
        },
        methods:{
            async loadList(){
                const url = "http://localhost:8080/pocketmon/";
                const resp = await axios.get(url);
                this.pocketmonList.push(...resp.data);
            },
        },

        created(){
            this.loadList();
        },
    };
</script>

<style scoped>

</style>