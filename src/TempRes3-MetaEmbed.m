% The variable freqCol (below) is the column containing the frequency values in the
% csv file.
freqCol = 2;


tempres=0.011 %Modify it according to the files - This is the value I used for the Valencia analysis
%tempres=0.012 %Modify it according to the files - This is the value I used for the Southall delphinus analysis

folder_name = uigetdir('C:\Users\mo55\Documents\Work\Artwarp-tempres'); %Code for selecting the folder
if (~folder_name); return; end;
cd (folder_name);

% loop through the txt files in the folder
fileList = dir([folder_name '\\*.csv']);


for i=1:length(fileList) 
    curFile = fileList(i).name;
    allCols = csvread(curFile,5,0);
    freqContour=allCols(:,freqCol)';
%    Ia(i)= ([fileList([2,i]), i]); %To select the second column of fileList i.e. the csv files in the folder for i rows????
%    fcontour=Ia(2,i)'; % Define fcontour as the second column of the csv files 
%    filename=sprintf('Ia%d.ctr', i); % Save new files as .ctr files
    [filepath,name,ext] = fileparts(curFile);
    filename = fullfile(filepath,[name '.ctr']);
    ctrlength=length(freqContour)*tempres;% this calculates the duration of each contour 
    save(filename,'freqContour','tempres','ctrlength')

end