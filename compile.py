import os
import sys
import pandoc
import shutil
import subprocess

if len(sys.argv) <= 1:
    raise Exception("Aufgabe als argument geben")

task = sys.argv[1]

if not task:
    raise FileNotFoundError("Übung nicht gefunden")

folder = os.getcwd() + f"/u_{task}"

src_files = os.listdir(folder + "/src");

if src_files:
    shutil.make_archive(f"{folder}/Übung {task}", "zip", folder + "/src")

readme_path = os.path.join(folder, "README.md")
pdf_output_path = os.path.join(folder, f"Übung_{task}.pdf")

# Run pandoc via subprocess
subprocess.run([
    "pandoc",
    f"{folder}/README.md",
    "-o",
    f"{folder}/Übung 3.pdf"
])
