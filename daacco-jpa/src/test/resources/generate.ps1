"" > C:\dev\test.txt
for ($i = 3879; $i -lt 4100; ) {

$j = $i
$k = $i+1
$l = $i+2
$i = $i + 3
"INSERT INTO FOO (ID, NAME) VALUES ($j, 'NAME1');" >> C:\dev\test.txt
"INSERT INTO FOOSUB (ID, SUBNAME, FOO_ID) VALUES ($k, 'SUBNAME1', $j);" >> C:\dev\test.txt
"INSERT INTO FOOSUB (ID, SUBNAME, FOO_ID) VALUES ($l, 'SUBNAME2', $j);" >> C:\dev\test.txt
}