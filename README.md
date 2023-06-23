## Parcial  - Sistema Clinica universidad del valle 
Fundamentos de programacion orientado a Eventos

Autores:
- Manuel Felipe Cardoso Forero.

Entregables:
- Diagrama de Clases
- URL del repositorio con el código de la aplicación
- Codigo Aplicacion

## Necesidad de usario
La clínica Univalle requiere el desarrollo de un software que le permita gestionar el registro de  pacientes.

## Requerimientos
- El usuario deberá ingresar la identificación del paciente, si la identificación se encuentra registrada, 
la aplicación deberá traer la información almacenada en la colección de datos y se desplegará en 
la interfaz gráfica de usuario, la información quedará disponible para ser modificada, y se podrá 
actualizar presionado clic en el botón actualizar.
- Si la identificación ingresada no existe en la colección de datos, deberá permitir ingresar la 
información y agregarla a la colección de datos, presionando clic en el botón grabar, que es el 
mismo botón actualizar, pero en este escenario se llamará grabar.
- En el combo box deberá estar cargadas todas las alergias almacenadas en la colección alergias. 
Al momento de estar editando la información, bien sea porque va a crear un registro nuevo o va a 
modificar información, se podrá agregar más alergias al paciente.
- Se adicionará alergias al paciente mediante la selección de una opción del combo box y luego
presionando clic sobre el botón Agregar, una vez realizado lo anterior, se mostrará el nombre de 
la alergia en el listado.
- Los datos deberán ser persistentes, bien sea en archivo binario o en archivos de texto.
