<template>
    <vuescroll>
        <div class="login-container">
            <div class="login">
                <div class="login-title">
                    <img src="login_title.png">
                </div>
                <Form
                    label-position="left"
                    ref="loginfrom"
                    :model="fromCustom"
                    class="loginfrom"
                >
                    <FromItem prop="user">
                        <Input type="text" placeholder="请输入用户名" v-model="fromCustom.user"/>
                    </FromItem>
                    <FromItem prop="password">
                        <Input type="password" placeholder="请输入密码" v-model="fromCustom.password"/>
                    </FromItem>
                    <FromItem style="...">
                        <Button class="sub" type="primary" :load="loading" @click="handleSubmit">
                            登录
                        </Button>
                    </FromItem>
                </Form>
            </div>
        </div>
    </vuescroll>
</template>

<script>

export default{
    name: "login",
    component:{vuescroll},
    data(){
        return{
            fromCustom:{
                user:"",
                password:""
            },
            load:false,
            redirect:undefined//登出时页面路径
        };
    },
    create(){

    },
    mouted(){},
}
</script>

<style lang="scss"></style>
<style lang="scss" scoped>
    @import "@/styles/globalColor.scss";

    .login-container{
        width: 100% ;
        position: absolute;
        /*height: 0;*/
        top: 0;
        bottom: 0;
        left: 0;
        background: rgba(0,0,0,0) url("login_bg.jpg") no-repeat;
        background-size: cover;
        background-position: 50%;
        overflow: hidden;
        .login{
            width: 546px;
            height: 420px;
            top: 180px;
            left: 90px;
            position: absolute;
            z-index: 11;
            .login-title{
                width: 479px;
                height: 79px;
                color: chartreuse;
                margin-bottom: 65px;
                font-family: Calibri;
            }
        }
    }
</style>

