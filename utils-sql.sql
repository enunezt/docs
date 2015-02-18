select t1.ide_casilla, t1.ide_concepto, a.ide_funcion
from tabla1 t1,
  (select t1.ide_casilla, t1.ide_concepto, t2.ide_funcion
  from tabla1 t1
  inner join tabla2 t2 on (
    t1.ide_formato=t2.ide_formato and
    t1.num_version_formato=t2.num_version_formato and
    t1.ide_grupo=t2.ide_grupo and
    t1.ide_casilla=t2.ide_casilla)
  where t1.ide_formato = XXXX
  ) a
where t1.ide_concepto = a.ide_concepto and ide_formato = 1248;
