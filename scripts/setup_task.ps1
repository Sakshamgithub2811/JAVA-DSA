# Configure Task Scheduler properly to allow battery mode and interactive display
$action = New-ScheduledTaskAction -Execute 'powershell.exe' -Argument '-ExecutionPolicy Bypass -File "e:\java Dsa\scripts\daily_notifier.ps1"'
$trigger = New-ScheduledTaskTrigger -Daily -At 10:00AM
$settings = New-ScheduledTaskSettingsSet -AllowStartIfOnBatteries -DontStopIfGoingOnBatteries -StartWhenAvailable
Register-ScheduledTask -TaskName 'DSADailyRevision' -Action $action -Trigger $trigger -Settings $settings -Force
Write-Host "Task registered successfully with battery mode enabled!" -ForegroundColor Green
