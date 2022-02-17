# simple-titles
Limit the file part of the window title only include the file name in Jetbrains IDEs.

Windows speech recognition fails when a window title is too long and other automations can
depend on consistent window titling, this alleviates the problem.

You can customize the way the simplification if formatted for both project and open file
within Preferences -> Tools -> Simple Title Format. You can choose to include any combination
of static text, default project/file name, or project/file name without path (simple). If you
would like to omit project or title completely, simply leave that field blank.

## Examples

Consider project and path yielding a title like `project-name [~/path/to/project/project-name] - file.ext (namespace.of.file)`

**Project Name Only**  
Project Format: {SIMPLE}  
File Format:  
Result: `project-name`

**Simple File Names**  
Project Format: {DEFAULT}  
File Format: {SIMPLE}  
Result: `project-name [~/path/to/project/project-name] - file.ext`

**Custom Text**  
Project Format: IDEA IDE - {SIMPLE}  
File Format: {SIMPLE}  
Result: `IDEA IDE project-name - file.ext`