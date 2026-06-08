Vamos a generar un proyecto, totalmente en Java, de un aplicactivo que permita la manipulación de ficheros, como escuchar una ruta, con una máscara de fichero concreta, y luego actuar. La primera cosa que haremos será ser capaces de copiar el fichero original en una o varias ubicaciones alternativas. A partir de ahí podemos ir añadiendo transformaciones, que pueden afectar, al nombre del fichero, al formato del mismo; convertir un bmp en Jpg, o en pdf, etc… Ejemplo de como puede ser la configuración:

 

<?xml version='1.0'?>

<Configura>

 

  <Procedures>

 

              <Procedimiento>           

                            <RutaCaptura>c:\RutaCaptura</RutaCaptura>

                            <Filtro>*.PDF</Filtro>

                            <Borrado>true</Borrado>

                            <RutaCopia>

                                          <Ruta>c:\RutaDestino1</Ruta>

                                          <Ruta>c:\RutaDestino2</Ruta>

                            </RutaCopia>

              </Procedimiento>

</Procedures>

</Configura>

 

Como ves puede tener múltiples configuraciones.

 

Luego pasaremos a ubicaciones más complejas; tanto de origen como de destino, por ejemplo, recibes un Json, y lo envias a un webservice, y la respuesta la encapsulas y la dejas en algún otro destino. Pero esto para luego. Un ejemplo de transformaciones complejas:

 

<?xml version='1.0'?>

<Configura>

  <UserBBDD>sa</UserBBDD>

  <PWDBBDD>Topcon1932</PWDBBDD>

  <BBDDServer>.\TOPCON</BBDDServer>

  <BBDDName>imagenet</BBDDName>

<!--

<MapNetworkDrive>z</MapNetworkDrive>

<MapNetworkUNC>\\10.2.1.56\ssee\Oftalmologia\BiometroL11T\Recibidos</MapNetworkUNC>

<MapNetworkUser>ituc0011</MapNetworkUser>

<MapNetworkPWD>3T5c0011</MapNetworkPWD>

<MapNetworkDomain>TOPCON</MapNetworkDomain>

<SubstDrive>E</SubstDrive>

<SubstRuta>d:\datos\inbox</SubstRuta>

-->

  <Procedures>

              <Procedimiento>

                            <ftpURL>ftp://ftp.topcon.es</ftpURL>

                            <ftpUser>hmanises</ftpUser>

                            <ftpPWD>@HM65n89s32s@</ftpPWD>

                            <Filtro>*.*</Filtro>

                            <Borrado>true</Borrado>

                            <Transformacion>FTPREAD</Transformacion>

                            <RutaCopia>

                                          <Ruta>C:\Datos\TONO</Ruta>

                            </RutaCopia>

              </Procedimiento>

             

              <Procedimiento>

                            <RutaCaptura>C:\Datos\TONO</RutaCaptura>

                            <Filtro>*.ZIP</Filtro>

                            <Borrado>true</Borrado>

                            <ZipPassword>Password</ZipPassword>

                            <Transformacion>ZIPFILE</Transformacion>

                            <RutaCopia>

                                          <Ruta>C:\Datos\worklist</Ruta>

                            </RutaCopia>

                            <Separador>,</Separador>

              </Procedimiento>

 

              <Procedimiento>

                            <RutaCaptura>C:\Datos\TONO</RutaCaptura>

                            <Filtro>*.csv</Filtro>

                            <Borrado>true</Borrado>

                            <Transformacion>HMANISES</Transformacion>

                            <RutaCopia>

                                          <Ruta>C:\Datos\worklist</Ruta>

                            </RutaCopia>

                            <Separador>,</Separador>

                            <Cabecera>true</Cabecera>

              </Procedimiento>

<!--

              <Procedimiento>

                            <RutaCaptura>C:\Datos\test\HUMPHREY</RutaCaptura>

                            <Filtro>*.*</Filtro>

                            <Borrado>true</Borrado>

                            <Transformacion>RECURSIVO</Transformacion>

                            <RutaCopia>

                                          <Ruta>C:\Datos\test\HUMPHREY</Ruta>

                            </RutaCopia>

              </Procedimiento>

 

              <Procedimiento>

                            <RutaCaptura>e:\</RutaCaptura>

                            <Filtro>*.*</Filtro>

                            <Borrado>true</Borrado>

                            <Transformacion>ALADDIN</Transformacion>

                            <IDPatMinLong>5</IDPatMinLong>

                            <RutaCopia>

                                          <Ruta>\\10.2.1.56\ssee\Oftalmologia\BiometroL11T\Recibidos</Ruta>

                            </RutaCopia>

              </Procedimiento>

-->

<!--        <Procedimiento>

                            <RutaCaptura>c:\datos\TEST\ENTRADA</RutaCaptura>

                            <Filtro>*.PDF</Filtro>

                            <Borrado>true</Borrado>

                            <HistDefault>########</HistDefault>

                            <CICDefault></CICDefault>

                            <NumSE>55</NumSE>

                            <TipoInforme>4</TipoInforme>

                            <Estado>DEF</Estado>

                            <Transformacion>OSAKIDETZA</Transformacion>

                            <PosicionIDPaciente>0</PosicionIDPaciente>

                            <RutaCopia>

                                          <Ruta>M:</Ruta>

                            </RutaCopia>

              </Procedimiento>

-->

<!--

<Procedimiento>

                            <RutaCaptura>C:\Datos\test\ENTRADA</RutaCaptura>

                            <Filtro>*.JPG</Filtro>

                            <Borrado>true</Borrado>

                            <FiltroSecundarios>*.jpg</FiltroSecundarios>

                          <RutaCapturaSecundarios>C:\Datos\test\Retina</RutaCapturaSecundarios>

                            <Transformacion>EYENUK</Transformacion>

                            <PosicionIDPaciente>0</PosicionIDPaciente>

                <Separador>_</Separador>

                            <RutaCopia>

                                          <Ruta>C:\Datos\test\Salida</Ruta>

                            </RutaCopia>

              </Procedimiento>

-->

<!--

<Procedimiento>

                            <RutaCaptura>C:\Datos\test\ENTRADA</RutaCaptura>

                            <Filtro>*.JPG</Filtro>

                            <Borrado>true</Borrado>

                            <Transformacion>UPRETINA</Transformacion>

                            <PosicionIDPaciente>0</PosicionIDPaciente>

                <Separador>_</Separador>

                            <RutaCopia>

                                          <Ruta>C:\Datos\test\Salida</Ruta>

                            </RutaCopia>

              </Procedimiento>

-->

</Procedures>

</Configura>
