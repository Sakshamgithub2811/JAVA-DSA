# DSA Daily Revision Notifier (Rich Popup & Cheatsheet Launcher)
# Usage: powershell -ExecutionPolicy Bypass -File "e:\java Dsa\scripts\daily_notifier.ps1"

$schedule = @{
    "Thursday" = @{
        Topic = "ARRAYS - Fresh Two-Pointers & In-Place (Kal Jo Kiye The!)"
        Questions = "1. LC 167 (Two Sum II - Sorted)`n2. LC 283 (Move Zeroes)`n3. LC 344 (Reverse String)"
        Cheatsheet = "e:\java Dsa\Love-Babbar\03-Arrays\REVISION_CHEATSHEET.md"
    }
    "Friday" = @{
        Topic = "ARRAYS - Backward Fill & Palindrome (Kal LC 88 Ke Liye Prime!)"
        Questions = "1. LC 125 (Valid Palindrome - Aaj Jo Kiya Tha!)`n2. LC 977 (Squares Sorted Array - Backward Fill)`n3. LC 26 (Remove Duplicates - In-Place)"
        Cheatsheet = "e:\java Dsa\Love-Babbar\03-Arrays\REVISION_CHEATSHEET.md"
    }
    "Saturday" = @{
        Topic = "LINKED LIST - Tortoise & Hare Cycles"
        Questions = "1. LC 876 (Middle Node)`n2. LC 141 (Cycle Detection)`n3. LC 142 (Cycle Starting Node)"
        Cheatsheet = "e:\java Dsa\Love-Babbar\07-LinkedList\REVISION_CHEATSHEET.md"
    }
    "Sunday" = @{
        Topic = "LINKED LIST - Reversal & Palindromes"
        Questions = "1. LC 206 (Reverse LL)`n2. LC 234 (Palindrome LL)"
        Cheatsheet = "e:\java Dsa\Love-Babbar\07-LinkedList\REVISION_CHEATSHEET.md"
    }
    "Monday" = @{
        Topic = "ARRAYS - Dutch National Flag & 3Sum"
        Questions = "1. LC 75 (Sort Colors - 0, 1, 2)`n2. LC 15 (3Sum Triplet)"
        Cheatsheet = "e:\java Dsa\Love-Babbar\03-Arrays\REVISION_CHEATSHEET.md"
    }
    "Tuesday" = @{
        Topic = "ARRAYS - Water Trapping & Containers"
        Questions = "1. LC 11 (Container Most Water)`n2. LC 42 (Trapping Rain Water)"
        Cheatsheet = "e:\java Dsa\Love-Babbar\03-Arrays\REVISION_CHEATSHEET.md"
    }
    "Wednesday" = @{
        Topic = "MIXED - Rapid Flashcard Blitz"
        Questions = "Scan all 6 Array Flashcards + 5 Linked List Flashcards (10 Mins)"
        Cheatsheet = "e:\java Dsa\DAILY_REVISION_SCHEDULE.md"
    }
}

$today = (Get-Date).DayOfWeek.ToString()
$todaySchedule = $schedule[$today]

# Load Windows Forms & Drawing
Add-Type -AssemblyName System.Windows.Forms
Add-Type -AssemblyName System.Drawing

# Create Stylish Card Form
$form = New-Object System.Windows.Forms.Form
$form.Text = "DSA Daily Revision: $today"
$form.Size = New-Object System.Drawing.Size(460, 320)
$form.StartPosition = "CenterScreen"
$form.TopMost = $true
$form.FormBorderStyle = [System.Windows.Forms.FormBorderStyle]::FixedDialog
$form.MaximizeBox = $false
$form.MinimizeBox = $false
$form.BackColor = [System.Drawing.Color]::FromArgb(24, 24, 27)

# Header Title
$lblTitle = New-Object System.Windows.Forms.Label
$lblTitle.Text = "☕ DSA DAILY REVISION ($today)"
$lblTitle.Font = New-Object System.Drawing.Font("Segoe UI", 13, [System.Drawing.FontStyle]::Bold)
$lblTitle.ForeColor = [System.Drawing.Color]::FromArgb(56, 189, 248) # Sky blue
$lblTitle.Location = New-Object System.Drawing.Point(20, 15)
$lblTitle.AutoSize = $true
$form.Controls.Add($lblTitle)

# Topic Label
$lblTopic = New-Object System.Windows.Forms.Label
$lblTopic.Text = "📌 Topic: $($todaySchedule.Topic)"
$lblTopic.Font = New-Object System.Drawing.Font("Segoe UI", 10, [System.Drawing.FontStyle]::Bold)
$lblTopic.ForeColor = [System.Drawing.Color]::FromArgb(74, 222, 128) # Green
$lblTopic.Location = New-Object System.Drawing.Point(20, 48)
$lblTopic.AutoSize = $true
$form.Controls.Add($lblTopic)

# Questions Box
$txtBox = New-Object System.Windows.Forms.Label
$txtBox.Text = "Aaj ke Questions (Sirf 10 mins dry run):`n`n$($todaySchedule.Questions)"
$txtBox.Font = New-Object System.Drawing.Font("Segoe UI", 10, [System.Drawing.FontStyle]::Regular)
$txtBox.ForeColor = [System.Drawing.Color]::FromArgb(244, 244, 245) # White
$txtBox.Location = New-Object System.Drawing.Point(20, 80)
$txtBox.Size = New-Object System.Drawing.Size(400, 120)
$form.Controls.Add($txtBox)

# Button: Open Cheatsheet
$btnOpen = New-Object System.Windows.Forms.Button
$btnOpen.Text = "📖 Open Cheatsheet"
$btnOpen.Font = New-Object System.Drawing.Font("Segoe UI", 9, [System.Drawing.FontStyle]::Bold)
$btnOpen.ForeColor = [System.Drawing.Color]::White
$btnOpen.BackColor = [System.Drawing.Color]::FromArgb(37, 99, 235) # Blue
$btnOpen.FlatStyle = [System.Windows.Forms.FlatStyle]::Flat
$btnOpen.Location = New-Object System.Drawing.Point(20, 220)
$btnOpen.Size = New-Object System.Drawing.Size(160, 38)
$btnOpen.Add_Click({
    Start-Process $todaySchedule.Cheatsheet
    $form.Close()
})
$form.Controls.Add($btnOpen)

# Button: Close / Dismiss
$btnClose = New-Object System.Windows.Forms.Button
$btnClose.Text = "✅ Done / Later"
$btnClose.Font = New-Object System.Drawing.Font("Segoe UI", 9)
$btnClose.ForeColor = [System.Drawing.Color]::FromArgb(200, 200, 200)
$btnClose.BackColor = [System.Drawing.Color]::FromArgb(39, 39, 42)
$btnClose.FlatStyle = [System.Windows.Forms.FlatStyle]::Flat
$btnClose.Location = New-Object System.Drawing.Point(280, 220)
$btnClose.Size = New-Object System.Drawing.Size(140, 38)
$btnClose.Add_Click({
    $form.Close()
})
$form.Controls.Add($btnClose)

# Auto close timer after 60 seconds so it doesn't linger forever
$timer = New-Object System.Windows.Forms.Timer
$timer.Interval = 60000
$timer.Add_Tick({
    $timer.Stop()
    $form.Close()
})
$timer.Start()

# Display Form
[void]$form.ShowDialog()
