<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css" />
    </head>
    <body>
        <form class="pure-form" style="padding: 15px" >
            <fieldset>
                <legend>Login form</legend>

                <input type="text" placeholder="請輸入帳號" id="username" name="username" value="${cookie.username.getValue()}"><p/>
                <input type="password" placeholder="請輸入密碼" id="password" name="password" value="${cookie.password.getValue()}"><p/>

                <label for="remember">
                    <input id="remember" type="checkbox" name="remember" ${cookie.remember.getValue()}> Remember me
                </label><p/>
                <input type="text" placeholder="請輸入認證碼" id="code" name="code" >
                <img src="/JavaWeb1122/servlet/AuthCodeServlet" valign="middle">
                <p/>
                
                
                <button type="submit" class="pure-button pure-button-primary">Sign in</button><p/>
                ${message}
            </fieldset>
        </form>
    </body>
</html>
