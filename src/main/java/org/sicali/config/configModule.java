package org.sicali.config;

import org.sicali.controllers.*;
import org.sicali.routes.*;
import org.sicali.services.*;

public class configModule {

    public static AsignaturaRoutes initAsignaturaRoutes() {
        AsignaturaRoutes ra = new AsignaturaRoutes();
        AsignaturaService as = new AsignaturaService(ra);
        AsignaturaController ac = new AsignaturaController(as);
        ra = new AsignaturaRoutes(ac);
        return ra;
    }

    public static AsistenciaRoutes initAsistenciaRoutes() {
        AsistenciaRoutes ra = new AsistenciaRoutes();
        AsistenciaService as = new AsistenciaService(ra);
        AsistenciaController ac = new AsistenciaController(as);
        ra = new AsistenciaRoutes(ac);
        return ra;
    }

    public static UsuarioRoutes initUsuarioRoutes() {
        UsuarioRoutes ru = new UsuarioRoutes();
        UsuarioService us = new UsuarioService(ru);
        UsuarioController uc = new UsuarioController(us);
        ru = new UsuarioRoutes(uc);
        return ru;
    }

    public static CicloRoutes initCicloRoutes() {
        CicloRoutes rc = new CicloRoutes();
        CicloService cs = new CicloService(rc);
        CicloController cc = new CicloController(cs);
        rc = new CicloRoutes(cc);
        return rc;
    }

    public static GrupoRoutes initGrupoRoutes() {
        GrupoRoutes rg = new GrupoRoutes();
        GrupoService gs = new GrupoService(rg);
        GrupoController gc = new GrupoController(gs);
        rg = new GrupoRoutes(gc);
        return rg;
    }

    public static EstudianteGrupoRoutes initEstudianteGrupoRoutes() {
        EstudianteGrupoRoutes re = new EstudianteGrupoRoutes();
        EstudianteGrupoService es = new EstudianteGrupoService(re);
        EstudianteGrupoController ec = new EstudianteGrupoController(es);
        re = new EstudianteGrupoRoutes(ec);
        return re;
    }

    public static GrupoAsignaturaRoutes initGrupoAsignaturaRoutes() {
        GrupoAsignaturaRoutes rga = new GrupoAsignaturaRoutes();
        GrupoAsignaturaService gas = new GrupoAsignaturaService(rga);
        GrupoAsignaturaController gac = new GrupoAsignaturaController(gas);
        rga = new GrupoAsignaturaRoutes(gac);
        return rga;
    }

    public static PeriodoRoutes initPeriodoRoutes() {
        PeriodoRoutes rp = new PeriodoRoutes();
        PeriodoService ps = new PeriodoService(rp);
        PeriodoController pc = new PeriodoController(ps);
        rp = new PeriodoRoutes(pc);
        return rp;
    }

    public static TutorEstudianteRoutes initTutorEstudianteRoutes() {
        TutorEstudianteRoutes rt = new TutorEstudianteRoutes();
        TutorEstudianteService ts = new TutorEstudianteService(rt);
        TutorEstudianteController tc = new TutorEstudianteController(ts);
        rt = new TutorEstudianteRoutes(tc);
        return rt;
    }

    // --- Módulos de Estadísticas ---
    public static EstadisticasDocenteRoutes initEstadisticasDocenteRoutes() {
        EstadisticasDocenteRoutes red = new EstadisticasDocenteRoutes();
        EstadisticasDocenteService esd = new EstadisticasDocenteService(red);
        EstadisticasDocenteController edc = new EstadisticasDocenteController(esd);
        red = new EstadisticasDocenteRoutes(edc);
        return red;
    }

    public static EstadisticasPorEstudianteRoutes initEstadisticasPorEstudianteRoutes() {
        EstadisticasPorEstudianteRoutes ree = new EstadisticasPorEstudianteRoutes();
        EstadisticasPorEstudianteService ese = new EstadisticasPorEstudianteService(ree);
        EstadisticasPorEstudianteController eec = new EstadisticasPorEstudianteController(ese);
        ree = new EstadisticasPorEstudianteRoutes(eec);
        return ree;
    }

    public static EstadisticasPorGrupoRoutes initEstadisticasPorGrupoRoutes() {
        EstadisticasPorGrupoRoutes reg = new EstadisticasPorGrupoRoutes();
        EstadisticasPorGrupoService esg = new EstadisticasPorGrupoService(reg);
        EstadisticasPorGrupoController egc = new EstadisticasPorGrupoController(esg);
        reg = new EstadisticasPorGrupoRoutes(egc);
        return reg;
    }

    public static EstadisticasTutorRoutes initEstadisticasTutorRoutes() {
        EstadisticasTutorRoutes ret = new EstadisticasTutorRoutes();
        EstadisticasTutorService est = new EstadisticasTutorService(ret);
        EstadisticasTutorController etc = new EstadisticasTutorController(est);
        ret = new EstadisticasTutorRoutes(etc);
        return ret;
    }
}
