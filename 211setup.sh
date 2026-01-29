pushd ~/bin
curl https://faculty.cs.usna.edu/~wcbrown/courses/S26SI211/211bash.sh > 211bash.sh
source 211bash.sh

if [ ! $(grep 'source ~/bin/211bash.sh' ~/.bashrc) ]
then
    echo 'source ~/bin/211bash.sh' >> ~/.bashrc
fi

pushd ~
gname=$(git config --get user.name)
echo "git username is $gname"
if [ "$gname" != "" ]
then
    if [ -d si211 ]
    then
	echo 'Warning! Moving existing ic111 directory to old.si211!'
	rm -rf old.si211
	mv -f si211 old.si211
    fi
    git clone git@github.com:$gname/si211.git
else
    echo 'Error! git account not configured on this machine ... see instructor!'
    exit 1
fi

# add appropriate .gitignore
gibody=$(cat <<EOF                                                                                                               
# This file describes files/directories we want                                                                                  
# git to ignore, i.e. never consider for version                                                                                 
# control.  If this is added after the fact, and                                                                                 
# we want to wipe any existing examples of such                                                                                  
# files from the repo and future versioning, do                                                                                  
# something like:                                                                                                                
# git ls-files | grep -E '[.](~|swp|swo)$' | xargs git rm --cached                                                               
# ... but for each pattern you are trying to wipe                                                                                
                                                                                                                                 
# emacs and vim temp files                                                                                                       
*~                                                                                                                               
                                                                                                                                 
# vim temp files                                                                                                                 
.*.swp                                                                                                                           
.*.swo                                                                                                                           
.swp                                                                                                                             
.swo                                                                                                                             
                                                                                                                                 
# vscode and python and misc DrRoche suggestions                                                                                 
.vscode/                                                                                                                         
.history/                                                                                                                        
*.vsix                                                                                                                           
*.o                                                                                                                              
__pycache__/                                                                                                                     
*.pyc                                                                                                                            
*.pyo                                                                                                                            
venv/                                                                                                                            
*.egg-info/                                                                                                                      
EOF
)
pushd ~/si211 >/dev/null
echo -e "$gibody" > .gitignore
git add .gitignore


# make additions to .emacs NOTE: Keep this up-to-date with drb.emacs
emacsadditions=$(cat <<EOF
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;USNA Computer Science Dept. Default .emacs file
;;;;         14 Mar 2001
;;;;Modified:
;;;;         28 Sep 2005 flc
;;;;         07 Jan 2010 cwb
;;;;         16 Jul 2024 cwb
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;SETTING YOUR LOAD-PATH
;;You may want to create your own lisp packages, or install ones written
;;by others.  To do this, you need the .el or .elc files located in a
;;directory on the load-path.  It is traditional to create a directory in
;;your home called elisp.  Place any elisp packeges in that directory.  Then you
;;uncomment the following line to add that directory to your load-path
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;(setq load-path (cons "~/elisp" load-path))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;GENERAL SETTINGS.  
;;These settings make sure your environment is nice for editing.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;When the frame has multiple windows, the following enables
;;you to use the arrow keys with the Meta ket to grow and shrink
;;the window. the bracket format is special to fsf emacs, thus why it's in
;;this file.
(global-set-key [M-up] 'enlarge-window)
(global-set-key [M-down] 'shrink-window)

(global-font-lock-mode t)		;Use pretty colors on text
(require 'mwheel)                       ; Makes mouse scroll wheel work
(setq visible-bell t)			;flashes the screen instead of beeping
(setq default-major-mode 'text-mode)	;deafualt mode is text
(define-key global-map "\C-h" 
  'backward-delete-char-untabify)	;ensure C-h will actually backspace
(define-key global-map "\e\C-h"		
  'backward-kill-word)			;M-h deletes an entire word.
(setq text-mode-hook 
  '(lambda () (auto-fill-mode 1)))	;auto-wraps lines in text mode
(define-key global-map "\e\C-z" 
  'help-for-help)			;help is a common enough need, so
					;give it a special key combo: C-M-z

(line-number-mode t)			;show the line number. default in FSF
(delete-selection-mode t)

;; When fill column is set, this makes line breaking automatic
(setq text-mode-hook 'turn-on-auto-fill)

;;By default, the automatic indenting of C (and related) code, is 2 spaces.
;;If you would like it to be more, change the value below.
(setq c-basic-offset 2)

;; These three commands display the time & date
(load "time" nil t)
(setq display-time-day-and-date t)  
(display-time)                      

;;; go to flyspell mode for .tex, .txt and .html files
(add-hook 'text-mode-hook 'flyspell-mode)
(add-hook 'latex-mode-hook 'flyspell-mode)
(add-hook 'LaTeX-mode-hook 'flyspell-mode)
(add-hook 'html-mode-hook 'flyspell-mode)

;; Sets the background color of hightlight to something pleasing
(set-face-attribute 'region nil :background "#dcdcdc")


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;OTHER SOURCES.  
;;;There are many other sources for ideas on how to customize your .emacs files.
;;;In particular, try:
;;;www.dotemacs.de
;;;www.dotfiles.com
;;;They are full of examples, both esoteric and mundane, of other peoples'
;;;.emacs files.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(custom-set-variables
 '(load-home-init-file t t))
(custom-set-faces)

;; Defines C/C++ and Java behavior.
;; 1st line - indents a "{" opening a block following an "if" or a loop.
;; 2nd line - displays line number before each line.
;; Comment out either line with a ; to turn off that option
(defun custom-cpp ()
  (c-set-offset 'substatement-open 0)
  (display-line-numbers-mode)
  )

(defun custom-java ()
  (c-set-offset 'substatement-open 0)
  (display-line-numbers-mode)
  )

(defun custom-python ()
  (display-line-numbers-mode)
  )

;; force C++ files to run custom-cpp and Java with custom-java
(add-hook 'c++-mode-hook  'custom-cpp)
(add-hook 'c-mode-hook  'custom-cpp)
(add-hook 'java-mode-hook  'custom-java)
(add-hook 'python-mode-hook  'custom-python)

;; Javascript cusomization: show line numbers before each line
(defun custom-javascript () (display-line-numbers-mode))
(add-hook 'js-mode-hook  'custom-javascript)


;;; Get .icc .l .ypp suffixed files to go into C++ mode automatically!
;;; Add .h to the list if you prefer .h files to be in C++ by default.
(setq auto-mode-alist
      (append '(("\\.C$"    . c++-mode)
		("\\.cc$"   . c++-mode)
		("\\.icc$"  . c++-mode) 
		("\\.l$"    . c++-mode) 
		("\\.ypp$"  . c++-mode) 
		) auto-mode-alist))

;; open with single window
(setq inhibit-startup-screen t)
(add-hook 'emacs-startup-hook 'delete-other-windows)
(setq inhibit-startup-buffer-menu t)
EOF
)

# overwrite .emacs with my version!
pushd ~
echo "$emacsadditions" >> .emacs
