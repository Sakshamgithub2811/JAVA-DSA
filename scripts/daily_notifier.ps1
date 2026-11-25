# DSA Daily Revision Notifier (Automatic Topic & Question Picker)
# Usage: powershell -ExecutionPolicy Bypass -File "e:\java Dsa\scripts\daily_notifier.ps1"

$schedule = @{
    "Thursday" = @{
        Topic = "ARRAYS - Fresh Two-Pointers & In-Place (Kal Jo Kiye The!)"
        Questions = "1. LC 167 (Two Sum II - Sorted)`n2. LC 283 (Move Zeroes)`n3. LC 344 (Reverse String)"
        Cheatsheet = "Love-Babbar\03-Arrays\REVISION_CHEATSHEET.md"
    }
    "Friday" = @{
        Topic = "ARRAYS - Reader-Writer & Filtering"
        Questions = "1. LC 26 (Remove Duplicates)`n2. LC 27 (Remove Element)`n3. LC 977 (Squares Sorted Array)"
        Cheatsheet = "Love-Babbar\03-Arrays\REVISION_CHEATSHEET.md"
    }
    "Saturday" = @{
        Topic = "LINKED LIST - Tortoise & Hare Cycles"
        Questions = "1. LC 876 (Middle Node)`n2. LC 141 (Cycle Detection)`n3. LC 142 (Cycle Starting Node)"
        Cheatsheet = "Love-Babbar\07-LinkedList\REVISION_CHEATSHEET.md"
    }
    "Sunday" = @{
        Topic = "LINKED LIST - Reversal & Palindromes"
        Questions = "1. LC 206 (Reverse LL)`n2. LC 234 (Palindrome LL)"
        Cheatsheet = "Love-Babbar\07-LinkedList\REVISION_CHEATSHEET.md"
    }
    "Monday" = @{
        Topic = "ARRAYS - Dutch National Flag & 3Sum"
        Questions = "1. LC 75 (Sort Colors - 0, 1, 2)`n2. LC 15 (3Sum Triplet)"
        Cheatsheet = "Love-Babbar\03-Arrays\REVISION_CHEATSHEET.md"
    }
    "Tuesday" = @{
        Topic = "ARRAYS - Water Trapping & Containers"
        Questions = "1. LC 11 (Container Most Water)`n2. LC 42 (Trapping Rain Water)"
        Cheatsheet = "Love-Babbar\03-Arrays\REVISION_CHEATSHEET.md"
    }
    "Wednesday" = @{
        Topic = "MIXED - Rapid Flashcard Blitz"
        Questions = "Scan all 6 Array Flashcards + 5 Linked List Flashcards (10 Mins)"
        Cheatsheet = "DAILY_REVISION_SCHEDULE.md"
    }
}

$today = (Get-Date).DayOfWeek.ToString()
$todaySchedule = $schedule[$today]

Write-Host "==========================================================" -ForegroundColor Cyan
Write-Host " [DSA DAILY REVISION] $($today): $($todaySchedule.Topic)" -ForegroundColor Green
Write-Host "==========================================================" -ForegroundColor Cyan
Write-Host "$($todaySchedule.Questions)" -ForegroundColor Yellow
Write-Host "`nReference: $($todaySchedule.Cheatsheet)" -ForegroundColor Gray
Write-Host "==========================================================" -ForegroundColor Cyan

# Windows Notification Popup
try {
    Add-Type -AssemblyName System.Windows.Forms
    Add-Type -AssemblyName System.Drawing

    $notify = New-Object System.Windows.Forms.NotifyIcon
    $notify.Icon = [System.Drawing.SystemIcons]::Information
    $notify.BalloonTipTitle = "DSA Today ($($today)): $($todaySchedule.Topic)"
    $notify.BalloonTipText = "$($todaySchedule.Questions)`n`nOpen $($todaySchedule.Cheatsheet)"
    $notify.Visible = $true
    $notify.ShowBalloonTip(10000)

    Start-Sleep -Seconds 5
    $notify.Dispose()
} catch {
    Write-Warning "Notification popup could not be rendered: $_"
}
