# IGI-Addon-RFTools
Tag support for RFTools in InGame-Info-XML

Special license permission: Lunatrius has explicit permission to make this mod obsolete by including the functionality directly into InGame-Info-XML via wholesale copying and modification to the namespaces to conform to his own.  In the event of this occurrence, all rights to the code will be transferred to Lunatrius.

Example usage:
```xml
<line>
  <str>Dim </str>
  <var>dimensionid</var>
  <str>: </str>
  <if>
    <var>rftdimension</var>
    <concat>
      <var>rftdimensionname</var>
      <str> (</str>
      <var>rftdimensionpower</var>
      <str> RF @ </str>
      <var>rftdimensioncost</var>
      <str> RF/t)</str>
    </concat>
    <var>dimension</var>
  </if>
</line>
```
