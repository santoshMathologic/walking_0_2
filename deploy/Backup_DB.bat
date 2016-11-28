set /p pathName=Enter FILE Name for Backup (eg. ABC.sql) :%=%
@echo %pathName%
mysqldump -u root --password="root" --routines walking_db > %pathName%