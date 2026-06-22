document.addEventListener("DOMContentLoaded", function () {
    const canvas = document.getElementById("financeChart");
    if (!canvas) return;

    fetch("/api/analytics/metrics")
        .then(r => r.json())
        .then(data => {
            new Chart(canvas, {
                type: "bar",
                data: {
                    labels: ["Доход", "Расход", "Баланс"],
                    datasets: [{
                        label: "Суммы",
                        data: [data.totalIncome, data.totalExpense, data.balance]
                    }]
                }
            });
        });
});