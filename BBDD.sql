-- TABLE CREATIONS ############################################################

-- CLASES ###################################

CREATE TABLE DIAGNOSTICO(
    idDiagnostico VARCHAR2(40) PRIMARY KEY,
    valoracion VARCHAR2(80),
    enfermedad VARCHAR2(50)
);

CREATE TABLE USUARIO(
    nombre VARCHAR2(40),
    apellidos VARCHAR2(60),
    usuario VARCHAR2(9) NOT NULL,
    clave VARCHAR2(20),
    tipo VARCHAR2(8),
    CONSTRAINT usuario_pk PRIMARY KEY (usuario)
);

CREATE TABLE MEDICO(
    nombre VARCHAR2(40),
    apellidos VARCHAR2(60),
    usuario VARCHAR2(9) NOT NULL,
    clave VARCHAR2(20),
    ncolegiado VARCHAR2(9),
    disponibilidad NUMBER(1),
    
    CONSTRAINT medico_pk PRIMARY KEY (usuario),
    CONSTRAINT medico_fk FOREIGN KEY (usuario) REFERENCES USUARIO(usuario) ON DELETE CASCADE
);

CREATE TABLE PACIENTE(
    nombre VARCHAR2(40),
    apellidos VARCHAR2(60),
    usuario VARCHAR2(9) NOT NULL,
    clave VARCHAR2(20),
    nss VARCHAR2(12),
    ntarjeta VARCHAR2(20),
    telefono VARCHAR2(9),
    direccion VARCHAR2(80),
    
    CONSTRAINT paciente_pk PRIMARY KEY (usuario),
    CONSTRAINT paciente_fk FOREIGN KEY (usuario) REFERENCES USUARIO(usuario) ON DELETE CASCADE
);

CREATE TABLE CITA(
    idCita VARCHAR2(40) PRIMARY KEY,
    fechaHora DATE,
    motivoCita VARCHAR2(80),
    idDiagnostico VARCHAR2(40),
    medico VARCHAR2(9),
    paciente VARCHAR2(9),
    
    CONSTRAINT cita_fk_diagnostico FOREIGN KEY (idDiagnostico) REFERENCES DIAGNOSTICO(idDiagnostico) ON DELETE CASCADE,
    CONSTRAINT cita_fk_medico FOREIGN KEY (medico) REFERENCES MEDICO(usuario) ON DELETE CASCADE,
    CONSTRAINT cita_fk_paciente FOREIGN KEY (paciente) REFERENCES PACIENTE(usuario) ON DELETE CASCADE
);

-- ASOCIACIONES #############################

-- ASOCIACION MEDICO PACIENTE
CREATE TABLE ASOC_MEDICO_PACIENTE(
    medico_id VARCHAR2(9),
    paciente_id VARCHAR2(9),
    
    FOREIGN KEY (medico_id) REFERENCES MEDICO(usuario) ON DELETE CASCADE,
    FOREIGN KEY (paciente_id) REFERENCES PACIENTE(usuario) ON DELETE CASCADE
);
